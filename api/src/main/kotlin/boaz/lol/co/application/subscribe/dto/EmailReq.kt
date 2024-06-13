package boaz.lol.co.application.subscribe.dto

import boaz.lol.co.domains.champion.Champion

data class EmailReq(
    val champions: List<Champion>
)