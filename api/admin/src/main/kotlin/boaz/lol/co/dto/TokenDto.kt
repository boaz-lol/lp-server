package boaz.lol.co.dto

import boaz.lol.co.enums.Role


data class TokenDto(
    val role: List<Role>,
    val accessToken: String,
    val refreshToken: String
)