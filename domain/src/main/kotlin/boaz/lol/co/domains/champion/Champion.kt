package boaz.lol.co.domains.champion

data class Champion(
    val id: Long,
    val name: String,
    val image: String,
    val detail: String,
    val type: String,
    val consumeType: String,
    val mainLine: String,
    val isActive: Boolean
)