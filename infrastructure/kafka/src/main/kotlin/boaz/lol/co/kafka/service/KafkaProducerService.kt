package boaz.lol.co.kafka.service


import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val objectMapper: ObjectMapper
) {

    fun sendMessage(topic: String, message: Any) {
        val jsonString = objectMapper.writeValueAsString(message)
        kafkaTemplate.send(topic, jsonString)
    }
}