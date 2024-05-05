package boaz.lol.co.application.account.controller

import boaz.lol.co.application.account.controller.dto.AccountRes
import boaz.lol.co.domains.account.*
import boaz.lol.co.dto.TokenDto
import boaz.lol.co.enums.Role
import boaz.lol.co.resolver.AuthAccountData
import boaz.lol.co.service.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController (
    private val accountService: AccountService,
    private val jwtService: JwtService
) {
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

    @PutMapping("/me")
    fun modifyAccountInfo (
        @AuthAccountData accountData: AccountData,
        @RequestBody req: AccountModify
    ): ResponseEntity<String> {
        accountService.modify(accountData, req)
        return ResponseEntity.ok("정상적으로 변경됨.")
    }

}
