package boaz.lol.co.domains.account

interface AccountService {
    fun register(accountCreate: AccountCreate): Account

    fun authorize(accountAuthorize: AccountAuthorize): Account

    fun getById(id: Long): Account

    fun modify(accountData: AccountData, accountModify: AccountModify): Account
}