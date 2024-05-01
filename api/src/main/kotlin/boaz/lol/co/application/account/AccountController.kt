package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.*
import boaz.lol.co.domains.account.AccountCreate
import boaz.lol.co.domains.account.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController(private val accountService: AccountService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody req: AccountCreate): ResponseEntity<String> {
        accountService.register(req);
        return ResponseEntity.ok("성공적으로 생성됨.");
    }

//    @PostMapping("/signin")
//    fun signIn(@RequestBody reqDto: SignInReq): ResponseEntity<String> {
//        // 로그인 요청 처리
//        val token = accountServiceImpl.signIn(reqDto)
//        return ResponseEntity.ok(token)
//    }
}
