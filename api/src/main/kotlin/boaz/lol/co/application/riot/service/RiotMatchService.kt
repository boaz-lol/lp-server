package boaz.lol.co.application.riot.service

import boaz.lol.co.infrastructure.riot.RiotMatchClient
import boaz.lol.co.storage.repository.MatchRepositoryImpl
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RiotMatchService(
    @Value("\${external.riot.key}") private val apiKey: String,
    private val riotMatchClient: RiotMatchClient,
    private val matchRepositoryImpl: MatchRepositoryImpl
) {
    fun getAllRiotMatchId (
        puuid: String
    ) : List<String> {
        return riotMatchClient.getRiotMatchIdsByPuuid(puuid, apiKey);
    }

    fun getMatchInfo (
        matchId: String
    ): Any {
        val match = riotMatchClient.getMatchDetail(matchId, apiKey)
        matchRepositoryImpl.save(match)
        return match;
    }
}