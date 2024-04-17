package boaz.lol.co.domains.account

import boaz.lol.co.domains.account.Account
interface AccountService {
    fun getByEmail(email: String): Account
}