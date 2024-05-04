package boaz.lol.co.infrastructure.riot

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "riotAccountClient", url = "https://asia.api.riotgames.com/riot/account/v1")
interface RiotAccountClient {
    @GetMapping("/accounts/by-riot-id/{gameName}/{tagLine}")
    fun getRiotAccount(@PathVariable gameName: String, @PathVariable tagLine: String, @RequestParam("api_key") apiKey: String) : RiotAccountInfo

}