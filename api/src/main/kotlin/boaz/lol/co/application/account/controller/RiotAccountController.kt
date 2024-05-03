package boaz.lol.co.application.account.controller

import boaz.lol.co.infrastructure.riot.RiotAccountClient
import boaz.lol.co.infrastructure.riot.RiotAccountInfo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts/riot")
class RiotAccountController(
    val riotAccountClient: RiotAccountClient
) {
    @GetMapping()
    fun getRiotAccountInfo(@RequestParam gameName: String, @RequestParam tagLine: String): ResponseEntity<RiotAccountInfo> {
        return ResponseEntity.ok(riotAccountClient.getRiotAccount(gameName, tagLine))
    }
}