package boaz.lol.co.infrastructure.riot

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "riotMatchClient", url = "https://asia.api.riotgames.com/lol/match/v5/matches")
interface RiotMatchClient {
    @GetMapping("/by-puuid/{puuid}/ids?start=0&count=40")
    fun getRiotMatchIdsByPuuid(@PathVariable puuid: String, @RequestParam("api_key") apiKey: String): List<String>
}