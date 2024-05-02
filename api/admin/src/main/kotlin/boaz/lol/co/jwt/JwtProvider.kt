package boaz.lol.co.jwt

import boaz.lol.co.enums.Role
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*


@Component
class JwtProvider (
    @Value("\${spring.jwt.secret}") secretKey: String
) {
    companion object {
        const val AUTHORITIES_KEY = "role"
        const val BEARER_TYPE = "Bearer "
    }

    private val key: Key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))

    fun generateJwt (subject: String, expirationTime: Long, role: List<Role>): String {
        val current: Date = Date()
        val claims: Claims = Jwts.claims()
            .setIssuedAt(current)
            .setExpiration(Date(current.time + expirationTime))
        claims.setSubject(subject)
        claims[AUTHORITIES_KEY] = role.stream().map { it -> it.name }.toList().joinToString(",")

        return BEARER_TYPE + Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .setClaims(claims)
            .signWith(key)
            .compact();
    }

    fun getAuthentication(accessToken: String): Authentication {
        val claims: Claims = parseClaims(accessToken)
        val authorities: Collection<GrantedAuthority> = claims[AUTHORITIES_KEY].toString().split(",")
            .map { it -> SimpleGrantedAuthority(it) }.toList()
        return UsernamePasswordAuthenticationToken(claims.subject.toLong(), "", authorities)
    }

    fun parseClaims(accessToken: String) : Claims {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).body
        } catch (e: Exception) {
            throw e
        }
    }

    fun getExpiration(accessToken: String): Long {
        val expirationDate = Jwts.parserBuilder()
            .setSigningKey(key)
            .build().parseClaimsJws(accessToken)
            .body.expiration
        return expirationDate.time - Date().time
    }

    fun validateToken(token: String): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            return true
        } catch (e: ExpiredJwtException) {
            throw e
        }
    }


}