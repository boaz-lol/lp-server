package boaz.lol.co.kafka.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/*
@Configuration
@ConfigurationProperties(prefix = "kafka")
class KafkaProperties {
    lateinit var bootstrapAddress: String
    lateinit var topic: Topic
    lateinit var producer: Producer
    lateinit var consumer: Consumer

    class Topic {
        lateinit var batch: TopicConfig
        lateinit var champion: TopicConfig

        class TopicConfig {
            lateinit var name: String
            var numPartitions: Int = 0
            var replicationFactor: Short = 1
        }
    }

    class Producer {
        lateinit var acksConfig: String
        var retry: Int = 0
        var enableIdempotence: Boolean = true
        var maxInFlightRequestsPerConnection: Int = 0
    }

    class Consumer {
        lateinit var autoOffsetResetConfig: String
        lateinit var batchGroupId: String
        lateinit var championGroupId: String
    }
}

 */
