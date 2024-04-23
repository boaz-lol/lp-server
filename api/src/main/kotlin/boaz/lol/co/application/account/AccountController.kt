package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(private val accountService: AccountService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody reqDto: SignUpReq): ResponseEntity<String> {
        // 회원 가입 요청 처리
        val accountEmail = accountService.signUp(reqDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("회원 가입이 완료되었습니다. Email: $accountEmail")
    }

    @PostMapping("/signin")
    fun signIn(@RequestBody reqDto: SignInReq): ResponseEntity<AccountRes> {
        // 로그인 요청 처리
        val account = accountService.signIn(reqDto)
        return ResponseEntity.ok(account)
    }
}