package boaz.lol.co.domains.account

data class Account(
    val id: Long,
    val email: String,
    val password: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
) {
    fun to() : AccountData {
        return AccountData(id, email, riotId)
    }
}