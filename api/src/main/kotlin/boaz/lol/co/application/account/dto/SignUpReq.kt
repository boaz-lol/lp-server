package boaz.lol.co.application.account.dto

data class SignUpReq(
    val email: String,
    val password: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val agreeToPersonalInfo: Boolean,
    val agreeToEmail: Boolean
)