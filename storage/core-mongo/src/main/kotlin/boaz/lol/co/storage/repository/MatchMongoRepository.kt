package boaz.lol.co.storage.repository

import boaz.lol.co.storage.entity.Match
import org.springframework.data.mongodb.repository.MongoRepository

interface MatchMongoRepository : MongoRepository<Match, String>