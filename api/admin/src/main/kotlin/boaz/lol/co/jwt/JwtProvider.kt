package boaz.lol.co.jwt

import boaz.lol.co.enums.Role
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*


@Component
class JwtProvider (
    @Value("\${spring.jwt.secret}") secretKey: String
) {
    companion object {
        const val AUTHORITIES_KEY = "role"
        const val BEARER_TYPE = "Bearer"
    }

    private val key: Key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))

    fun generateJwt (subject: String, expirationTime: Long, role: List<Role>): String {
        val current: Date = Date()
        val claims: Claims = Jwts.claims()
            .setIssuedAt(current)
            .setExpiration(Date(current.time + expirationTime))
        claims.setSubject(subject)
        claims[AUTHORITIES_KEY] = role.stream().map { it -> it.name }.toList().joinToString(",")

        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .setClaims(claims)
            .signWith(key)
            .compact();
    }


}