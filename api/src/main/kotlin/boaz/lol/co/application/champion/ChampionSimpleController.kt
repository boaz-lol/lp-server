package boaz.lol.co.application.champion

import boaz.lol.co.application.champion.response.ChampionSimpleRes
import boaz.lol.co.domains.champion.ChampionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/champions")
class ChampionSimpleController(
    private val championService: ChampionService
) {
    @GetMapping
    fun championFindAll(): ResponseEntity<List<ChampionSimpleRes>> =
        ResponseEntity.ok().body(championService.getChampionList().map { ChampionSimpleRes(it) })

    @GetMapping("/{id}")
    fun championFindById(@PathVariable id: Long): ResponseEntity<ChampionSimpleRes> =
        ResponseEntity.ok(ChampionSimpleRes(championService.getSingleChampion(id)))
}