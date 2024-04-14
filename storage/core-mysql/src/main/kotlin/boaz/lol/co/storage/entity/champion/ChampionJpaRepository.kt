package boaz.lol.co.storage.entity.champion

import org.springframework.data.jpa.repository.JpaRepository

interface ChampionJpaRepository: JpaRepository<ChampionEntity, Long>