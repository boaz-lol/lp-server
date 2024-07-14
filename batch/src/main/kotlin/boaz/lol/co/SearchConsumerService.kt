package boaz.lol.co

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class SearchConsumerService {
    @KafkaListener(
        topics = ["riot_account_search"],
        groupId = "springboot"
    )
    @Throws(IOException::class)
    fun listen(msg: String?) {
        println(String.format("Consumed message : %s", msg))
    }
}