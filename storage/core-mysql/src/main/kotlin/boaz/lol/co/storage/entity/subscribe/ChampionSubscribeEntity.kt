package boaz.lol.co.storage.entity.subscribe

import boaz.lol.co.storage.common.BaseEntity
import boaz.lol.co.storage.entity.account.AccountEntity
import boaz.lol.co.storage.entity.champion.ChampionEntity
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="champion_subscribe")
class ChampionSubscribeEntity(
    @ManyToOne
    val account: AccountEntity,

    @ManyToOne
    val champion: ChampionEntity
): BaseEntity()