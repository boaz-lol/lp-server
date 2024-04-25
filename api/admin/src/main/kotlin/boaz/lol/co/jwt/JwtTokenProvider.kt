package boaz.lol.co.jwt

import boaz.lol.co.domains.account.base.Role
import boaz.lol.co.dto.TokenDto
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.*
import java.util.stream.Collectors
import javax.crypto.SecretKey

@Component
class JwtTokenProvider @Autowired constructor(
    @Value("\${jwt.secret-key}") secretKey: String
) {

    private val secretKey: SecretKey = TODO()

    init {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey))
    }

    // 만료 시간 관리
    companion object {
        private val ACCESS_TOKEN_EXPIRE_TIME: Long = Duration.ofHours(3).toMillis()
        private val REFRESH_TOKEN_EXPIRE_TIME: Long = Duration.ofDays(5).toMillis()
    }

    // 사용자 인증 정보와 사용자 ID를 기반으로 JWT 액세스 토큰과 리프레시 토큰을 생성합니다.
    fun createTokens(authentication: Authentication, userIdx: Long): TokenDto {
        val roles = authentication.authorities.stream()
            .map { authority -> Role.valueOf(authority.authority.uppercase()) }
            .collect(Collectors.toList())
            .first()

        return TokenDto(
            role = roles,
            accessToken = createAccessToken(authentication, userIdx),
            refreshToken = createRefreshToken(authentication, userIdx)
        )
    }

    // 액세스 토큰 생성
    fun createAccessToken(authentication: Authentication, userIdx: Long): String {
        // 사용자의 역할을 가져와서 콤마로 분리된 문자열로 변환
        val roles = authentication.authorities.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","))

        return Jwts.builder()
            // Header: 토큰의 타입(JWT)과 서명에 사용된 알고리즘(HS512) 정보
            .header()
            .add("type", "JWT")     // 토큰의 타입 지정. 여기서는 JWT를 사용.
            .and()

            // Payload: 토큰에 담을 클레임(데이터)을 지정
            .issuer("lp-server")            // iss 클레임: 토큰 발급자를 지정
            .subject(authentication.name)       // sub 클레임: 토큰 제목을 지정
            .expiration(Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME))    // exp 클레임: 토큰 만료 시간을 지정
            .issuedAt(Date())                   // iat 클레임: 토큰 발급 시간을 지정
            .claim("role", roles)         // 사용자 정의 클레임: 사용자의 역할
            .claim("id", userIdx)         // 사용자 정의 클레임: 사용자의 식별자

            .signWith(secretKey)                // signWith 메소드를 사용해 서명 알고리즘과 키를 지정
            .compact()
    }

    // 리프레시 토큰 생성
    fun createRefreshToken(authentication: Authentication, userIdx: Long): String {
        return Jwts.builder()
            .subject(authentication.name)               // sub 클레임: 토큰 제목을 지정
            .issuer("lp-server")            // iss 클레임: 토큰 발급자를 지정
            .issuedAt(Date())                           // iat 클레임: 토큰 발급 시간을 지정
            .expiration(Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRE_TIME))       // exp 클레임: 토큰 만료 시간을 지정
            .claim("id", userIdx)          // 사용자 정의 클레임: 사용자의 식별자
            .signWith(secretKey)                        // signWith 메소드를 사용해 서명 알고리즘과 키를 지정
            .compact()                                  // 마지막으로 compact 메소드를 호출해 모든 부분을 합쳐서 하나의 JWT 토큰 문자열을 생성한다
    }

    // 토큰 검증 메서드
    fun validateToken(token: String): Boolean {
        try {
            val claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token)
            return !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            return false
        }
    }

    //
    fun getAuthentication(token: String): Authentication {
        val claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).body
        val authorities = (claims["roles"] as List<String>).map { SimpleGrantedAuthority(it) }
        return UsernamePasswordAuthenticationToken(claims.subject, null, authorities)
    }

}
