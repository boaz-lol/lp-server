package boaz.lol.co.application.champion

import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.domains.champion.ChampionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/champions")
class ChampionSimpleController(
    private val championService: ChampionService
) {
    @GetMapping()
    fun championFindAll(): ResponseEntity<List<Champion>> {
        return ResponseEntity.ok(championService.getChampionList());
    }
}