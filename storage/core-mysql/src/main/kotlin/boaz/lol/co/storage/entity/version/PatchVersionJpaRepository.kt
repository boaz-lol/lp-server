package boaz.lol.co.storage.entity.version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PatchVersionJpaRepository : JpaRepository<PatchVersionEntity, Long> {
}
