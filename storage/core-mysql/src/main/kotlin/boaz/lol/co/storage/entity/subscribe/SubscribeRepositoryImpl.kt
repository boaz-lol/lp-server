package boaz.lol.co.storage.entity.subscribe

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.domains.subscribe.Subscribe
import boaz.lol.co.domains.subscribe.SubscribeRepository
import boaz.lol.co.storage.entity.account.AccountEntity
import boaz.lol.co.storage.entity.account.AccountJpaRepository
import boaz.lol.co.storage.entity.champion.ChampionEntity
import boaz.lol.co.storage.entity.champion.ChampionJpaRepository
import org.springframework.stereotype.Repository

@Repository
class SubscribeRepositoryImpl(
    private val accountJpaRepository: AccountJpaRepository,
    private val championJpaRepository: ChampionJpaRepository,
    private val subscribeJpaRepository: SubscribeJpaRepository
) : SubscribeRepository {
    override fun getByAccount(account: Account): Subscribe {
        val subscribeList: List<ChampionSubscribeEntity> = subscribeJpaRepository.findAllByAccount(AccountEntity(account));
        return Subscribe(account, subscribeList.map{it.champion.to()})
    }

    override fun addSubscribe(account: Account, champion: Champion) {
        val accountEntity = accountJpaRepository.findById(account.id).orElseThrow()
        val championEntity = championJpaRepository.findById(champion.id).orElseThrow()
        val subscription = ChampionSubscribeEntity(accountEntity, championEntity)
        subscribeJpaRepository.save(subscription)
    }

    override fun deleteSubscribe(account: Account, champion: Champion) {
        val accountEntity = accountJpaRepository.findById(account.id).orElseThrow()
        val championEntity = championJpaRepository.findById(champion.id).orElseThrow()
        val subscription = subscribeJpaRepository.findByAccountAndChampion(accountEntity, championEntity)
            ?: throw NoSuchElementException("구독 정보를 찾을 수 없음.")
        subscribeJpaRepository.delete(subscription)
    }

    override fun getAccountsByChampions(champions: List<Champion>): List<Account> {
        val championEntities = champions.map { ChampionEntity(it) }
        val subscriptions = subscribeJpaRepository.findAllByChampionIn(championEntities)
        return subscriptions.map { it.account.to() }.distinct()
    }
}