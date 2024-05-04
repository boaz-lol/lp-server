package boaz.lol.co.application.account.service

import boaz.lol.co.domains.account.*
import boaz.lol.co.service.PasswordService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val passwordService: PasswordService
) : AccountService {

    override fun register(accountCreate: AccountCreate): Account {
        if (accountRepository.existByEmail(accountCreate.email)) {
            throw IllegalArgumentException("이미 존재하는 이메일입니다.")
        }
        else {
            accountCreate.encryptPassword(passwordService.encryptPassword(accountCreate.password))
        }
        return accountRepository.add(accountCreate)
    }

    override fun authorize(accountAuthorize: AccountAuthorize): Account {
        val account: Account = accountRepository.getByEmail(accountAuthorize.email)
            .orElseThrow { IllegalArgumentException("일치하는 이메일을 찾을 수 없습니다.") }
        if (!passwordService.isValidPassword(accountAuthorize.password, account.password)) {
            throw IllegalArgumentException("올바르지 않은 비밀번호입니다.")
        }
        return account
    }

    @Transactional(readOnly = true)
    override fun getById(id: Long): Account {
        return accountRepository.getById(id)
            .orElseThrow {IllegalArgumentException("올바르지 않은 접근입니다.")}
    }

}
