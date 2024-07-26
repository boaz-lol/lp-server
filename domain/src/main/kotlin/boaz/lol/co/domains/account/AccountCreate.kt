package boaz.lol.co.domains.account

data class AccountCreate (
    val email: String,
    var password: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
) {
    fun encryptPassword(encodedPassword: String) {
        this.password = encodedPassword
    }
}