package boaz.lol.co.application.account.controller

import boaz.lol.co.application.account.controller.dto.RiotAccountRes
import boaz.lol.co.application.account.service.AccountServiceImpl
import boaz.lol.co.application.account.service.RiotAccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts/riot")
class RiotAccountController(
    private val riotAccountService: RiotAccountService,
    private val accountService: AccountServiceImpl
) {
    @GetMapping
    fun getRiotAccountInfo(@RequestParam gameName: String, @RequestParam tagLine: String): ResponseEntity<RiotAccountRes> {
        return ResponseEntity.ok(RiotAccountRes.from(riotAccountService.getRiotAccount(gameName, tagLine)))
    }

    @GetMapping("/search")
    fun searchByGameInfo(@RequestParam gameName: String, @RequestParam tagLine: String): ResponseEntity<List<RiotAccountRes>> {
        return ResponseEntity.ok(
            accountService.searchByGameInfo(gameName, tagLine)
                .map { it -> RiotAccountRes.from(it) }.toList()
        )
    }
}