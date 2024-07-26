package boaz.lol.co.storage.entity

import jakarta.persistence.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = "riot_account")
data class RiotAccount(
    @Field("puuid")
    val puuid: String,
    @Id
    var id: String? = null
)