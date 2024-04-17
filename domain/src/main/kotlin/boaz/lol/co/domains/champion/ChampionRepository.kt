package boaz.lol.co.domains.champion

import java.util.Optional

interface ChampionRepository {
    fun getAll(): List<Champion>

    fun getById(id: Long): Optional<Champion>
}