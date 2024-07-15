package boaz.lol.co

import boaz.lol.co.infrastructure.riot.RiotMatchClient
import boaz.lol.co.storage.repository.MatchRepositoryImpl
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class SearchConsumerService(
    private val riotMatchClient: RiotMatchClient,
    private val matchRepository: MatchRepositoryImpl,
    @Value("\${external.riot.key}") private val apiKey: String
) {
    @KafkaListener(
        topics = ["riot_account_search"],
        groupId = "springboot"
    )
    @Throws(Exception::class)
    fun listen(msg: String) {
        println(msg)
        val matchIds: List<String> = riotMatchClient.getRiotMatchIdsByPuuid(msg, apiKey)
        for (id: String in matchIds) {
            if (matchRepository.existsByMatchId(id)) {
                continue
            }
            val match = riotMatchClient.getMatchDetail(id, apiKey)
            println(matchRepository.save(match))
        }
    }
}