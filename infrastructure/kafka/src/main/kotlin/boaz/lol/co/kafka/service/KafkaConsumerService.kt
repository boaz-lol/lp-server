package boaz.lol.co.kafka.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @KafkaListener(
        topics = ["\${kafka.topic.batch.name}"],
        groupId = "\${kafka.consumer.batchGroupId}",
        containerFactory = "kafkaListenerContainerFactoryBatch"
    )
    fun consumeBatchEvent(message: String, ack: Acknowledgment) {
        // println("배치 관련: $message")
        ack.acknowledge()
    }

    @KafkaListener(
        topics = ["\${kafka.topic.champion.name}"],
        groupId = "\${kafka.consumer.championGroupId}",
        containerFactory = "kafkaListenerContainerFactoryChampion"
    )
    fun consumeChampionEvent(message: String, ack: Acknowledgment) {
        // println("챔피언 관련: $message")
        ack.acknowledge()
    }
}
