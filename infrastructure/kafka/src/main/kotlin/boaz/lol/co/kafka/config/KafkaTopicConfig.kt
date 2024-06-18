package boaz.lol.co.kafka.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    fun batchTopic(): NewTopic {
        val topicConfig = kafkaProperties.topic.batch
        return NewTopic(topicConfig.name, topicConfig.numPartitions, topicConfig.replicationFactor)
    }

    @Bean
    fun championTopic(): NewTopic {
        val topicConfig = kafkaProperties.topic.champion
        return NewTopic(topicConfig.name, topicConfig.numPartitions, topicConfig.replicationFactor)
    }
}
