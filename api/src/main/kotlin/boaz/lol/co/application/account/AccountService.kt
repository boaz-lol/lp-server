package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.SignUpReq
import boaz.lol.co.application.account.dto.SignInReq
import boaz.lol.co.application.account.dto.AccountRes

interface AccountService {
    fun signUp(reqDto: SignUpReq): AccountRes
    fun signIn(reqDto: SignInReq): String
}
