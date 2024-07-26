package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "version_champion")
class VersionChampionEntity(
    @Column
    val champion: Long,

    @Column
    val patch: Long
) : BaseEntity()