package boaz.lol.co.domains.version

interface ChampionInfoRepository {
    fun findUpdatedChampionsByLatestPatchVersion(): List<ChampionInfo>
}
