package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "champion_status")
class ChampionStatusEntity (
    @Column
    val champion: Long,

    @Column
    val attack: Int,

    @Column
    val armor: Int,

    @Column
    val spellBlock: Int,

    @Column
    val attackRange: Int,

    @Column
    val hp: Int,

    @Column
    val mp: Int,

    @Column
    val critical: Int,

    @Column
    val speed: Int,

    @Column
    val moveSpeed: Int,

    @Column
    val hpRecover: Int,

    @Column
    val mpRecover: Int,

    @Column
    val attackPerLevel: Int,

    @Column
    val hpPerLevel: Int,

    @Column
    val mpPerLevel: Int,

    @Column
    val armorPerLevel: Int,

    @Column
    val spellPerLevel: Int,

    @Column
    val criticalPerLevel: Int,

    @Column
    val hpRecoverPerLevel: Int,

    @Column
    val mpPerRecoverLevel: Int
) : BaseEntity()