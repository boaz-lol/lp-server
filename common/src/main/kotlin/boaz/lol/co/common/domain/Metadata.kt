package boaz.lol.co.common.domain

data class Metadata(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>
)