package boaz.lol.co.domains.champion

import boaz.lol.co.domains.account.Account
import java.util.Optional
import java.util.*

interface ChampionRepository {
    fun getAll(): List<Champion>
    fun getById(id: Long): Optional<Champion>
}