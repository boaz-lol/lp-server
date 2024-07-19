package boaz.lol.co

import boaz.lol.co.common.domain.Participant
import boaz.lol.co.infrastructure.riot.RiotMatch
import boaz.lol.co.infrastructure.riot.RiotMatchClient
import boaz.lol.co.storage.entity.Match
import boaz.lol.co.storage.entity.RiotAccount
import boaz.lol.co.storage.repository.MatchDetailRepository
import boaz.lol.co.storage.repository.MatchRepositoryImpl
import boaz.lol.co.storage.repository.RiotAccountRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MatchService(
    private val matchDetailRepository: MatchDetailRepository,
    private val matchRepository: MatchRepositoryImpl,
    private val riotAccountRepository: RiotAccountRepository,
    private val riotMatchClient: RiotMatchClient,
    @Value("\${external.riot.key}") private val apiKey: String,
) {

    @Transactional(readOnly = true)
    fun readAccountList() : List<RiotAccount> {
        return riotAccountRepository.findAll()
    }

    fun addAnother() {
        val puuidList: List<RiotAccount> = readAccountList();
        for (riotAccount:RiotAccount in puuidList) {
            val matchIds: List<String> = riotMatchClient.getRiotMatchIdsByPuuid(riotAccount.puuid, apiKey)
            for (id: String in matchIds) {
                if (matchRepository.existsByMatchId(id)) {
                    break
                }
                val riotMatch: RiotMatch = riotMatchClient.getMatchDetail(id, apiKey)
                val match = matchRepository.save(
                    Match(riotMatch.metadata, riotMatch.info)
                ) as Match

                for (participant: Participant in match.info.participants) {
                    
                }

            }
        }
    }
}