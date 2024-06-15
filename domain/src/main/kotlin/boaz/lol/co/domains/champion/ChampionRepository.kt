package boaz.lol.co.domains.champion

import java.util.*

interface ChampionRepository {
    fun getAll(): List<Champion>
    fun getById(id: Long): Optional<Champion>
    fun getByIds(ids: List<Long>): List<Champion>
}