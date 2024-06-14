package boaz.lol.co.application.champion.response

import boaz.lol.co.domains.champion.Champion

class ChampionSimpleRes (
    val id: Long,
    val name: String,
    val image: String,
    val mainLine: String,
    val isActive: Boolean
) {
    constructor(champion: Champion) : this(
        id=champion.id,
        name=champion.name,
        image=champion.image,
        mainLine=champion.mainLine,
        isActive=champion.isActive
    )
}