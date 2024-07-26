package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name="champion_status")
class ChampionPassiveEntity(
    @Column
    val champion: Long,

    @Column
    val delay: String,

    @Column
    val detail: String
) : BaseEntity()