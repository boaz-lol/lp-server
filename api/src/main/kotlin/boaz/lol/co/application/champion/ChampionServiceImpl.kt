package boaz.lol.co.application.champion

import boaz.lol.co.domains.champion.Champion
import boaz.lol.co.domains.champion.ChampionRepository
import boaz.lol.co.domains.champion.ChampionService
import org.springframework.stereotype.Service

@Service
class ChampionServiceImpl(
    private val championRepository: ChampionRepository
) : ChampionService {
    override fun getChampionList(): List<Champion> {
        return championRepository.getAll();
    }

    override fun getSingleChampion(id: Long): Champion {
        return championRepository.getById(id)
            .orElseThrow{ IllegalArgumentException("유효하지 않은 id입니다.") };
    }
}