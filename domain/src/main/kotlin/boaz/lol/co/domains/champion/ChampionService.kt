package boaz.lol.co.domains.champion

interface ChampionService {
    fun getChampionList(): List<Champion>

    fun getSingleChampion(id: Long): Champion
}