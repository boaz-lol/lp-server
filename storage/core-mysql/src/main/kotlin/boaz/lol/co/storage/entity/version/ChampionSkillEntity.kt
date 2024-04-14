package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "champion_skill")
class ChampionSkillEntity(
    @OneToOne(
        mappedBy = "champion"
    )
    val champion: VersionChampionEntity,

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