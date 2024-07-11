package boaz.lol.co.storage.repository

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.insert
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

@Repository
class MatchRepositoryImpl(
    private val mongoTemplate: MongoTemplate
) {
    fun save(match: Any) {
        mongoTemplate.insert(match, "matches")
    }
}