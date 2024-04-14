package boaz.lol.co.storage.entity.version

import boaz.lol.co.storage.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name="patch_version")
class PatchVersionEntity(
    @Column
    val number: String,

    @Column
    val subVersion: String,

    @Column
    val expectedAt: LocalDateTime,

    @Column
    val appliedAt: LocalDateTime
): BaseEntity() {
}