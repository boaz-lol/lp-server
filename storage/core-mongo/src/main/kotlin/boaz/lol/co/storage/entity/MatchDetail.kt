package boaz.lol.co.storage.entity

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Document(collation = "data_sources")
class MatchDetail(
    @Field("match_id")
    private val matchId: String,

    @Field("puuid")
    private val puuid: String,

    @Field("role")
    private val role: String,

    @Field("champion_id")
    private val championId: Int,

    @Field("champ_level")
    private val champLevel: Int,

    @Field("win")
    private val win: Boolean,

    @Field("damages_per_minute")
    private val damagesPerMinute: Double,

    @Field("damage_taken_on_team_percentage")
    private val damageTakenOnTeamPercentage: Double,

    @Field("gold_per_minute")
    private val goldPerMinute: Double,

    @Field("team_damage_percentage")
    private val teamDamagePercentage: Double,

    @Field("kda")
    private val kda: Double,

    @Field("game_creation")
    private val gameCreation: LocalDateTime
) {
    @Id
    private val id: String? = null

    @Field("created_at")
    private val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        private fun convertTimestamp(timestamp: Long): LocalDateTime {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
        }
    }
}