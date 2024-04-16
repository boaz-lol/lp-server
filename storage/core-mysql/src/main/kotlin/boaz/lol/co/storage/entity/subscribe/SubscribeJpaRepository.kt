package boaz.lol.co.storage.entity.subscribe

import boaz.lol.co.storage.entity.account.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SubscribeJpaRepository : JpaRepository<ChampionSubscribeEntity, Long> {
    fun findAllByAccount(account: AccountEntity): List<ChampionSubscribeEntity>
}