package boaz.lol.co.service

import boaz.lol.co.dto.TokenDto
import boaz.lol.co.enums.Role
import boaz.lol.co.jwt.JwtProvider
import boaz.lol.co.storage.redis.service.RedisUtil
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.DurationUnit

@Service
class AuthService (
    private val jwtProvider: JwtProvider,
    private val redisUtil: RedisUtil
) {
    private val accessTokenExpireTime: Long = 2.hours.toLong(DurationUnit.MICROSECONDS)
    private val refreshTokenExpireTime: Long = 14.days.toLong(DurationUnit.MICROSECONDS)

    fun issueJwt(id: Long, role: List<Role>) : TokenDto {
        val accessToken: String =  jwtProvider.generateJwt(id.toString(), accessTokenExpireTime, role)
        val refreshToken: String = jwtProvider.generateJwt(id.toString(), refreshTokenExpireTime, role)
        redisUtil.setValues(refreshToken.substringAfter("Bearer ").trim(), id.toString())
        return TokenDto(
            role,
            accessToken,
            refreshToken,
        )
    }

    fun reissue(refreshToken: String) : TokenDto {
        val token: String = refreshToken.substringAfter("Bearer+").trim()
        val id: String = redisUtil.getValues(token)!!
        val role: List<Role> = jwtProvider.parseClaims(token)["role"].toString().split(",")
            .map { it -> Role.valueOf(it)}.toList()
        return TokenDto(
            role,
            jwtProvider.generateJwt(id, accessTokenExpireTime, role),
            "",
        )
    }

    fun generateCookie(refreshToken: String): ResponseCookie {
        val encodedToken = URLEncoder.encode(refreshToken, StandardCharsets.UTF_8.toString())
        return ResponseCookie
            .from("refreshToken", encodedToken)
            .httpOnly(true)
            .secure(true)
            .sameSite("None")
            .path("/accounts")
            .build()
    }

}