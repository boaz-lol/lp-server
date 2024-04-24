package boaz.lol.co.dto

data class TokenDto(
    val role: String,
    val accessToken: String,
    val refreshToken: String
)