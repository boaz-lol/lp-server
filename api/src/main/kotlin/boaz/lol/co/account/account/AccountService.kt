package boaz.lol.co.account.account

import boaz.lol.co.domains.account.Account
interface AccountService {
    fun getByEmail(email: String): Account
}