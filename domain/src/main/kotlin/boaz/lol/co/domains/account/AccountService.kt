package boaz.lol.co.domains.account

interface AccountService {
    fun register(accountCreate: AccountCreate): Account

    fun authorize(accountAuthorize: AccountAuthorize): Account
}