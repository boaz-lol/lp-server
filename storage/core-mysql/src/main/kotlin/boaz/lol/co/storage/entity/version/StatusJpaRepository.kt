package boaz.lol.co.storage.entity.version

import org.springframework.data.jpa.repository.JpaRepository

interface StatusJpaRepository : JpaRepository<ChampionPassiveEntity, Long>