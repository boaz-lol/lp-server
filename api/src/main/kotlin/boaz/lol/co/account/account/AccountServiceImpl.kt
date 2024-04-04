package boaz.lol.co.account.account

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
): AccountService {
    override fun getByEmail(email: String): Account {
        TODO("Not yet implemented")
    }
}