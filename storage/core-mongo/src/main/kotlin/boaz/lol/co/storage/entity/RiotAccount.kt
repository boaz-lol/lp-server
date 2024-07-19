package boaz.lol.co.storage.entity

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collation = "riot_account")
data class RiotAccount(
    @Field("puuid")
    val puuid: String,
) {
    @Id
    private val id: String? = null

    @Field("created_at")
    private val createdAt: LocalDateTime = LocalDateTime.now()
}