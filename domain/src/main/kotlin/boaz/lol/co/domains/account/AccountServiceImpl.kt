package boaz.lol.co.domains.account

import boaz.lol.co.application.account.dto.SignUpReq
import boaz.lol.co.application.account.dto.SignInReq
import boaz.lol.co.application.account.dto.AccountRes
import boaz.lol.co.application.account.AccountService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class AccountServiceImpl @Autowired constructor(private val accountRepository: AccountRepository) : AccountService {

    override fun signUp(reqDto: SignUpReq): String {

    }

    override fun signIn(reqDto: SignInReq): AccountRes {
    }

}
