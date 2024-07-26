package boaz.lol.co.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer

/*
@EnableKafka
@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun batchConsumerFactory(): ConsumerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = kafkaProperties.consumer.batchGroupId
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = kafkaProperties.consumer.autoOffsetResetConfig
        return DefaultKafkaConsumerFactory(
            props,
            StringDeserializer(),
            ErrorHandlingDeserializer(JsonDeserializer(Any::class.java))
        )
    }

    @Bean
    fun championConsumerFactory(): ConsumerFactory<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = kafkaProperties.consumer.championGroupId
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = kafkaProperties.consumer.autoOffsetResetConfig
        return DefaultKafkaConsumerFactory(
            props,
            StringDeserializer(),
            ErrorHandlingDeserializer(JsonDeserializer(Any::class.java))
        )
    }

    @Bean
    fun kafkaListenerContainerFactoryBatch(): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = batchConsumerFactory()
        factory.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL
        return factory
    }

    @Bean
    fun kafkaListenerContainerFactoryChampion(): ConcurrentKafkaListenerContainerFactory<String, Any> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = championConsumerFactory()
        factory.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL
        return factory
    }
}


 */