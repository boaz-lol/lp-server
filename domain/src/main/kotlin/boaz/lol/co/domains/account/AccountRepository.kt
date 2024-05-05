package boaz.lol.co.domains.account

import java.util.*

interface AccountRepository {
    fun getById(id: Long): Optional<Account>
    fun getByEmail(email: String): Optional<Account>
    fun existByEmail(email: String): Boolean
    fun add(account: AccountCreate): Account
    fun modify(id: Long, updated: AccountModify): Account
}