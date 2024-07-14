package boaz.lol.co.storage.repository

import boaz.lol.co.storage.entity.MatchDetail
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class MatchDetailRepository(
    private val mongoTemplate: MongoTemplate
) {
    fun save(match: MatchDetail) {
        mongoTemplate.insert(match, "data_source")
    }
}