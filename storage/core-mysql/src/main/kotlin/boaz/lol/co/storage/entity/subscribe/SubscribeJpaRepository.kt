package boaz.lol.co.storage.entity.subscribe

import boaz.lol.co.storage.entity.account.AccountEntity
import boaz.lol.co.storage.entity.champion.ChampionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SubscribeJpaRepository : JpaRepository<ChampionSubscribeEntity, Long> {
    fun findAllByAccount(account: AccountEntity): List<ChampionSubscribeEntity>
    fun findByAccountAndChampion(account: AccountEntity, champion: ChampionEntity): ChampionSubscribeEntity?
    fun findAllByChampionIn(champions: List<ChampionEntity>): List<ChampionSubscribeEntity>
}