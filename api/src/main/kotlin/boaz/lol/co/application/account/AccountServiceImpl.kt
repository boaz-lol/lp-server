package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.AccountRes
import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountCreate
import boaz.lol.co.domains.account.AccountRepository
import boaz.lol.co.domains.account.AccountService
import boaz.lol.co.domains.account.base.Role
import boaz.lol.co.service.PasswordService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val passwordService: PasswordService
) : AccountService {

    override fun register(accountCreate: AccountCreate): Account {
        if (accountRepository.existByEmail(accountCreate.email)) {
            throw IllegalArgumentException("이미 존재하는 이메일입니다.")
        }
        accountCreate.encryptPassword(passwordService.encryptPassword(accountCreate.password))
        return accountRepository.add(accountCreate)
    }

}
