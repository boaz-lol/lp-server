package boaz.lol.co.storage.entity.subscribe

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.domains.subscribe.Subscribe
import boaz.lol.co.domains.subscribe.SubscribeRepository
import boaz.lol.co.storage.entity.account.AccountEntity
import boaz.lol.co.storage.entity.champion.ChampionJpaRepository
import org.springframework.stereotype.Repository

@Repository
class SubscribeRepositoryImpl(
    private val accountJpaRepository: SubscribeJpaRepository,
    private val championJpaRepository: ChampionJpaRepository,
    private val subscribeJpaRepository: SubscribeJpaRepository
) : SubscribeRepository {
    override fun getByAccount(account: Account): Subscribe {
        val subscribeList: List<ChampionSubscribeEntity> = subscribeJpaRepository.findAllByAccount(AccountEntity(account));
        return Subscribe(account, subscribeList.map{it.champion.to()})
    }

    override fun addSubscribe(account: Account, champion: Champion) {
        TODO("Not yet implemented")
    }

    override fun deleteSubscribe(account: Account, champion: Champion) {
        TODO("Not yet implemented")
    }
}