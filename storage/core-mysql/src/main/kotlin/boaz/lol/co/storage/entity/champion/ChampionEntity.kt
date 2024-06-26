package boaz.lol.co.storage.entity.champion

import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.storage.common.BaseEntity
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
    val image: String,

    @Column
    val consumeType: String,

    @Column
    val mainLine: String,

    @Column
    val isActive: Boolean
): BaseEntity() {

    fun to(): Champion {
        return Champion(id, name, detail, type, consumeType, mainLine, image, isActive)
    }
}