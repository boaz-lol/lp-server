package boaz.lol.co.domains.version

interface PatchVersionRepository {
    fun getLatestPatchVersion(): PatchVersion?
    fun getUpdatedChampionIds(patchVersionId: Long): List<Long>
}
