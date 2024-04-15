package boaz.lol.co.storage.entity.subscribe

import org.springframework.data.jpa.repository.JpaRepository

interface SubscribeJpaRepository : JpaRepository<Long, ChampionSubscribeEntity>