package boaz.lol.co.storage.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["boaz.lol.co.storage"])
class MongoDBConfig (
    @Value("\${spring.data.mongodb.uri}") private val connectionString: String
) {
    private val logger = LoggerFactory.getLogger(MongoDBConfig::class.java)

    @Bean
    fun mongoDatabaseFactory(): MongoDatabaseFactory {
        logger.info("MongoDB 연결 문자열: $connectionString")
        return SimpleMongoClientDatabaseFactory(connectionString)
    }

    @Bean
    fun mongoTemplate(): MongoTemplate {
        return try {
            MongoTemplate(mongoDatabaseFactory())
        } catch (e: Exception) {
            logger.error("Error creating MongoTemplate", e)
            throw e
        }
    }
}