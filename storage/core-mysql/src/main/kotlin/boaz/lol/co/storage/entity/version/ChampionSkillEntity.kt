package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "champion_skill")
class ChampionSkillEntity(
    @Column
    val champion: Long,

    @Column
    val keyType: String,

    @Column
    val detail: String,

    @Column
    val consume: String,

    @Column
    val delay: String,

    @Column
    val maxLevel: Int
) : BaseEntity() {
}