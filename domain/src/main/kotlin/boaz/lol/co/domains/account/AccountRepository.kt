package boaz.lol.co.domains.account

import java.util.*

interface AccountRepository {
    fun getById(id: Long): Optional<Account>
}