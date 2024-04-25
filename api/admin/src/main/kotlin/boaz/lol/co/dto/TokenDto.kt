package boaz.lol.co.dto

import boaz.lol.co.domains.account.base.Role

data class TokenDto(
    val role: Role,
    val accessToken: String,
    val refreshToken: String
)