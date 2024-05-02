package boaz.lol.co.application.account

import boaz.lol.co.application.account.dto.*
import boaz.lol.co.domains.account.AccountAuthorize
import boaz.lol.co.domains.account.AccountCreate
import boaz.lol.co.domains.account.AccountData
import boaz.lol.co.domains.account.AccountService
import boaz.lol.co.dto.TokenDto
import boaz.lol.co.enums.Role
import boaz.lol.co.resolver.AuthAccountData
import boaz.lol.co.service.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController(private val accountService: AccountService, private val jwtService: JwtService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody req: AccountCreate): ResponseEntity<String> {
        accountService.register(req);
        return ResponseEntity.ok("성공적으로 생성됨.");
    }

    @PostMapping("/signin")
    fun signIn(@RequestBody req: AccountAuthorize): ResponseEntity<TokenDto> {
        val token = jwtService.issueJwt(accountService.authorize(req).id, listOf(Role.USER))
        return ResponseEntity.ok(token)
    }

    @GetMapping("/me")
    fun getAccountInfo(@AuthAccountData accountData: AccountData) : ResponseEntity<AccountRes> {
        return ResponseEntity.ok(AccountRes.from(accountService.getById(accountData.id)))
    }
}
