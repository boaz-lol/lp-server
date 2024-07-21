package boaz.lol.co

import boaz.lol.co.common.domain.Participant
import boaz.lol.co.infrastructure.riot.RiotMatch
import boaz.lol.co.infrastructure.riot.RiotMatchClient
import boaz.lol.co.kafka.service.KafkaProducerService
import boaz.lol.co.storage.entity.Match
import boaz.lol.co.storage.entity.MatchDetail
import boaz.lol.co.storage.entity.RiotAccount
import boaz.lol.co.storage.repository.MatchDetailRepository
import boaz.lol.co.storage.repository.MatchRepositoryImpl
import boaz.lol.co.storage.repository.RiotAccountRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Service
class MatchService(
    private val matchDetailRepository: MatchDetailRepository,
    private val matchRepository: MatchRepositoryImpl,
    private val riotAccountRepository: RiotAccountRepository,
    private val riotMatchClient: RiotMatchClient,
    private val kafkaProducerService: KafkaProducerService,
    @Value("\${external.riot.key}") private val apiKey: String,
) {

    @Transactional(readOnly = true)
    fun readAccountList() : List<RiotAccount> {
        return riotAccountRepository.findAll()
    }

    @Transactional
    fun addAnother() {
        val puuidList: List<RiotAccount> = riotAccountRepository.findAll();
        for (riotAccount in puuidList) {
            val matchIds: List<String> = riotMatchClient.getRiotMatchIdsByPuuid(riotAccount.puuid, apiKey)
            if (matchIds.isEmpty()) {
                break
            }
            for (id: String in matchIds) {
                if (matchRepository.existsByMatchId(id)) {
                    break
                }
                println(riotMatchClient.getMatchDetail(id, apiKey))
                val riotMatch: RiotMatch = riotMatchClient.getMatchDetail(id, apiKey)

                val match = matchRepository.save(
                    Match(riotMatch.metadata, riotMatch.info)
                ) as Match

                println("match save done")

                for (participant: Participant in match.info.participants) {
                    val matchDetail: MatchDetail = matchDetailRepository.save(
                        MatchDetail(
                            match.metadata.matchId,
                            participant.puuid,
                            participant.role,
                            participant.championId,
                            participant.champLevel,
                            participant.win,
                            participant.challenges.damagePerMinute,
                            participant.challenges.damageTakenOnTeamPercentage,
                            participant.challenges.goldPerMinute,
                            participant.challenges.damageTakenOnTeamPercentage,
                            participant.challenges.kda,
                            LocalDateTime.ofInstant(Instant.ofEpochMilli(match.info.gameCreation), ZoneId.systemDefault()),
                            LocalDateTime.now()
                        )
                    );

                    println("matchDetail save done")

                    kafkaProducerService.sendMessage("riot_match_rating", matchDetail)

                    println("kafka done")

                    if (!riotAccountRepository.isExists(participant.puuid)) {
                        riotAccountRepository.save(RiotAccount(puuid = participant.puuid))
                    }
                }

            }
        }


    }
}