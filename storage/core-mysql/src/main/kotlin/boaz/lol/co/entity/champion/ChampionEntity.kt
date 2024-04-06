package boaz.lol.co.entity.champion

import boaz.lol.co.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="champion")
class ChampionEntity(
    @Column
    val name: String,

    @Column(columnDefinition = "text")
    val detail: String,

    // TODO("Type Enum 지정")
    @Column
    val type: String,

    @Column
    val consumeType: String,

    @Column
    val mainLine: String,

    @Column
    val isActive: Boolean
): BaseEntity() {
}