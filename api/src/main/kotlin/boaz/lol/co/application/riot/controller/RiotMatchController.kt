package boaz.lol.co.application.riot.controller

import boaz.lol.co.application.riot.service.RiotMatchService
import boaz.lol.co.infrastructure.riot.RiotMatchClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/riot/matches")
class RiotMatchController(
    private val riotMatchService: RiotMatchService
) {
    @GetMapping()
    fun getRiotMatchIdsByRiotPuuid(@RequestParam puuid: String) : ResponseEntity<List<String>> {
        return ResponseEntity.ok(riotMatchService.getAllRiotMatchId(puuid))
    }
}