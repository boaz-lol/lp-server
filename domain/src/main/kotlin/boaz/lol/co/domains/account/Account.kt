package boaz.lol.co.domains.account

data class Account(
    val id: Long,
    var email: String,
    val password: String,
    var riotName: String,
    var riotTag: String,
    var riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
) {
    fun to() : AccountData {
        return AccountData(id, email, riotId)
    }

    fun update(accountModify: AccountModify) {
        this.email = accountModify.email
        this.riotName = accountModify.riotName
        this.riotTag = accountModify.riotTag
        this.riotId = accountModify.riotId
    }
}