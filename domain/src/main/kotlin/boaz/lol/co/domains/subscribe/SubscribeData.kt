package boaz.lol.co.domains.subscribe

data class SubscribeData(
    val accountId: Long,
    val championIds: List<Long>
)