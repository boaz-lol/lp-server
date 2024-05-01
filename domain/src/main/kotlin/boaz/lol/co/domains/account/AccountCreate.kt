package boaz.lol.co.domains.account

data class AccountCreate (
    val email: String,
    val password: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
)