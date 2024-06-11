package boaz.lol.co.domains.account

data class AccountModify(
    val email: String,
    var password: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
) {
    fun equal(account: Account) : Boolean {
        return account.email == email
                && account.riotName == riotName
                && account.riotTag == riotTag
                && account.riotId == riotId
    }

}