package boaz.lol.co.storage.entity.champion

import boaz.lol.co.domains.champion.ChampionRepository
import org.springframework.stereotype.Repository

@Repository
class ChampionRepositoryImpl(
    private val championRepository: ChampionRepository
): ChampionRepository {
}