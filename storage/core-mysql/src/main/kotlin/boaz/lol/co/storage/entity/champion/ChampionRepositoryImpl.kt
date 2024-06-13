package boaz.lol.co.storage.entity.champion

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.domains.champion.ChampionRepository
import boaz.lol.co.storage.entity.account.AccountEntity
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ChampionRepositoryImpl(
    private val championJpaRepository: ChampionJpaRepository
): ChampionRepository {

    override fun getById(id: Long): Optional<Champion> {
        return championJpaRepository.findById(id).map(ChampionEntity::to)
    }
}