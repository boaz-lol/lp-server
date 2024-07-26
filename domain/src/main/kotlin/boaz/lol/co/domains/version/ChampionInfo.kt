package boaz.lol.co.domains.version

import boaz.lol.co.domains.champion.Champion

data class ChampionInfo (
    val champion: Champion,
    val patchVersion: PatchVersion,
    val passive: ChampionPassive,
    val skillList: List<ChampionSkill>,
    val status: ChampionStatus
)