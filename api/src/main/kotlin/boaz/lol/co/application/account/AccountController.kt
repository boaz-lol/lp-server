package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(private val accountServiceImpl: AccountServiceImpl) {

//    @PostMapping("/signup")
//    fun signUp(@RequestBody reqDto: SignUpReq): ResponseEntity<AccountRes> {
//        // 회원 가입 요청 처리
//        val accountRes = accountServiceImpl.signUp(reqDto)
//        return ResponseEntity.status(HttpStatus.CREATED).body(accountRes)
//    }
//
//    @PostMapping("/signin")
//    fun signIn(@RequestBody reqDto: SignInReq): ResponseEntity<String> {
//        // 로그인 요청 처리
//        val token = accountServiceImpl.signIn(reqDto)
//        return ResponseEntity.ok(token)
//    }
}
