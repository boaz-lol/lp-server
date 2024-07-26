package boaz.lol.co.storage.entity

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Document(collection = "data_sources")
data class MatchDetail(
    @Field("match_id")
    val matchId: String,

    @Field("puuid")
    val puuid: String,

    @Field("role")
    val role: String,

    @Field("champion_id")
    val championId: Int,

    @Field("champ_level")
    val champLevel: Int,

    @Field("win")
    val win: Boolean,

    @Field("damages_per_minute")
    val damagesPerMinute: Double,

    @Field("damage_taken_on_team_percentage")
    val damageTakenOnTeamPercentage: Double,

    @Field("gold_per_minute")
    val goldPerMinute: Double,

    @Field("team_damage_percentage")
    val teamDamagePercentage: Double,

    @Field("kda")
    val kda: Double,

    @Field("game_creation")
    val gameCreation: LocalDateTime,

    @Field("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Id
    val id: String? = null,

    ) {
}