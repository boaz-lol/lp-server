package boaz.lol.co.application.account.dto

// 클라이언트 응답용 DTO
data class AccountRes(
    val id: Long,
    val email: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
)