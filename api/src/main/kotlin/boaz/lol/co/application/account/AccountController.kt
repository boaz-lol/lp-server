package boaz.lol.co.application.account

import boaz.lol.co.domains.account.AccountServiceImpl
import boaz.lol.co.application.account.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/acccount")
class AccountController(private val accountServiceImpl: AccountServiceImpl) {

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpReqDto: SignUpReq): ResponseEntity<String> {
        // 회원 가입 요청 처리
        val accountEmail = accountServiceImpl.signUp(signUpReqDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("회원 가입이 완료되었습니다. Email: $accountEmail")
    }

    @PostMapping("/signin")
    fun signIn(@RequestBody signInReqDto: SignInReq): ResponseEntity<AccountRes> {
        // 로그인 요청 처리
        val account = accountServiceImpl.signIn(signInReqDto)
        return ResponseEntity.ok(account)
    }
}