package boaz.lol.co.storage.repository

import boaz.lol.co.storage.entity.RiotAccount
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
class RiotAccountRepository(
    private val mongoTemplate: MongoTemplate
) {
    fun findAll(): List<RiotAccount> {
        return mongoTemplate.findAll(RiotAccount::class.java, "riot_account")
    }
}