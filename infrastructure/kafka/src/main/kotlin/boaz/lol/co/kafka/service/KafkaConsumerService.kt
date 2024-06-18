package boaz.lol.co.kafka.service

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.TopicPartition
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
        println("Received batch message: $message")
        // batch 관련 로직
        ack.acknowledge()
    }

    @KafkaListener(
        topics = ["\${kafka.topic.champion.name}"],
        groupId = "\${kafka.consumer.championGroupId}",
        containerFactory = "kafkaListenerContainerFactoryChampion"
    )
    fun consumeChampionEvent(message: String, ack: Acknowledgment) {
        println("Received champion message: $message")
        // Add your champion processing logic here
        ack.acknowledge()
    }
}
