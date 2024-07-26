package boaz.lol.co.storage.repository

import boaz.lol.co.storage.entity.Match
import jakarta.transaction.Transactional
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class MatchRepositoryImpl(
    private val mongoTemplate: MongoTemplate
) {
    fun save(match: Match) : Match {
        return mongoTemplate.insert(match, "matches")
    }

    fun findAll(): List<Match> {
        return mongoTemplate.findAll(Match::class.java, "matches")
    }

    fun findByMatchId(matchId: String): Match? {
        val query = Query(Criteria.where("metadata.matchId").`is`(matchId))
        return mongoTemplate.findOne(query, Match::class.java, "matches")
    }

    fun existsByMatchId(matchId: String): Boolean {
        val query = Query(Criteria.where("metadata.matchId").`is`(matchId))
        return mongoTemplate.exists(query, Match::class.java, "matches")
    }
}