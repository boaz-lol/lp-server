package boaz.lol.co.storage.entity.version

import boaz.lol.co.domains.version.PatchVersion
import boaz.lol.co.domains.version.PatchVersionRepository
import org.springframework.stereotype.Repository

@Repository
class PatchVersionRepositoryImpl(
    private val jpaRepository: PatchVersionJpaRepository
) : PatchVersionRepository {

    override fun getLatestPatchVersion(): PatchVersion? {
        val entity = jpaRepository.findLatestPatchVersion()
        return entity?.let {
            PatchVersion(
                number = it.number,
                subVersion = it.subVersion,
                expectedAt = it.expectedAt,
                appliedAt = it.appliedAt
            )
        }
    }

    override fun getUpdatedChampionIds(patchVersionId: Long): List<Long> {
        return jpaRepository.findUpdatedChampionIdsByPatchVersion(patchVersionId)
    }
}
