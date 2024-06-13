package boaz.lol.co.domains.champion

import boaz.lol.co.domains.account.Account
import java.util.*

interface ChampionRepository {
    fun getById(id: Long): Optional<Champion>
}