package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.AccountRes
import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountRepository
import boaz.lol.co.domains.account.AccountService
import boaz.lol.co.domains.account.base.Role
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    var accountRepository: AccountRepository
) : AccountService {

    override fun register(email: String, password: String, role: Role) {
        // 이메일 중복 확인
        if (AccountRepository.getByEmail(email)) {
            throw EmailAlreadyExistsException(email)
        }
    }

    override fun verifyUser(email: String, password: String): Long {
        TODO("Not yet implemented")
    }

    override fun getUserInfo(id: Long): AccountRes {
        TODO("Not yet implemented")
    }

}
