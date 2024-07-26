package boaz.lol.co.storage.repository

import boaz.lol.co.storage.entity.RiotAccount
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.exists
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
class RiotAccountRepository(
    private val mongoTemplate: MongoTemplate
) {
    fun findAll(): List<RiotAccount> {
        return mongoTemplate.findAll(RiotAccount::class.java, "riot_account")
    }

    fun save(entity: RiotAccount): RiotAccount {
        return mongoTemplate.save(entity, "riot_account")
    }

    fun isExists(puuid: String): Boolean {
        val query = Query(Criteria.where("puuid").`is`(puuid))
        return mongoTemplate.exists(query, RiotAccount::class.java, "riot_account")
    }
}