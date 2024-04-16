package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name="patch_version")
class PatchVersionEntity(
    @Column
    val number: String,

    @Column
    val subVersion: String,

    @Column
    val expectedAt: LocalDate,

    @Column
    val appliedAt: LocalDate
): BaseEntity() {
}