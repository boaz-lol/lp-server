package boaz.lol.co.dto

data class UserDetailsDTO(
    val username: String,
    val userId: Long,
    val roles: List<String>
)