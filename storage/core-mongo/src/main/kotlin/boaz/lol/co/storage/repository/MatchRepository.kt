package boaz.lol.co.storage.repository

import jakarta.transaction.Transactional
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class MatchRepositoryImpl(
    private val mongoTemplate: MongoTemplate
) {
    fun save(match: Any) {
        mongoTemplate.insert(match, "matches")
    }
}