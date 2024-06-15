package boaz.lol.co.storage.entity.version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PatchVersionJpaRepository : JpaRepository<PatchVersionEntity, Long> {

    @Query("SELECT p FROM PatchVersionEntity p ORDER BY p.appliedAt DESC")
    fun findLatestPatchVersion(): PatchVersionEntity?

    @Query("SELECT v.champion FROM VersionChampionEntity v WHERE v.patch = :patchVersionId")
    fun findUpdatedChampionIdsByPatchVersion(patchVersionId: Long): List<Long>
}
