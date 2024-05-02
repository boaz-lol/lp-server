package boaz.lol.co.service

import boaz.lol.co.dto.TokenDto
import boaz.lol.co.enums.Role
import boaz.lol.co.jwt.JwtProvider
import org.springframework.stereotype.Service
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.DurationUnit

@Service
class JwtService (
    private val jwtProvider: JwtProvider
) {
    private val accessTokenExpireTime: Long = 2.hours.toLong(DurationUnit.MICROSECONDS)
    private val refreshTokenExpireTime: Long = 14.days.toLong(DurationUnit.MICROSECONDS)

    fun issueJwt(id: Long, role: List<Role>) : TokenDto {
        return TokenDto(
            role,
            jwtProvider.generateJwt(id.toString(), accessTokenExpireTime, role),
            jwtProvider.generateJwt(id.toString(), refreshTokenExpireTime, role),
        )
    }
}