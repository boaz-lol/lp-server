package boaz.lol.co.application.account.service

import boaz.lol.co.infrastructure.riot.RiotAccountClient
import boaz.lol.co.infrastructure.riot.RiotAccount
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
@Service
class RiotAccountService (
    private val riotAccountClient: RiotAccountClient,
    @Value("\${external.riot.key}") private val apiKey: String
) {
    fun getRiotAccount(gameName: String, tagLine: String):  RiotAccount {
        return riotAccountClient.getRiotAccount(gameName, tagLine, apiKey)
    }
}