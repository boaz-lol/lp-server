package boaz.lol.co.application.account

import boaz.lol.co.domains.account.Account
interface AccountService {
    fun getByEmail(email: String): Account
}