package boaz.lol.co.domains.version

data class ChampionStatus (
    val attack: Int,
    val armor: Int,
    val spellBlock: Int,
    val attackRange: Int,
    val hp: Int,
    val mp: Int,
    val critical: Int,
    val speed: Int,
    val moveSpeed: Int,
    val hpRecover: Int,
    val mpRecover: Int,
    val attackPerLevel: Int,
    val hpPerLevel: Int,
    val mpPerLevel: Int,
    val armorPerLevel: Int,
    val spellPerLevel: Int,
    val criticalPerLevel: Int,
    val hpRecoverPerLevel: Int,
    val mpPerRecoverLevel: Int
)