package boaz.lol.co.application.account.service

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountRepository
import boaz.lol.co.domains.account.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
): AccountService {
    override fun getByEmail(email: String): Account {
        TODO("Not yet implemented")
    }
}