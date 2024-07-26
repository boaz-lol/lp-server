package boaz.lol.co.storage.entity.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AccountJpaRepository : JpaRepository<AccountEntity, Long> {
    fun findByEmail(email: String): Optional<AccountEntity>
    fun existsByEmail(email: String): Boolean
    fun findAllByRiotNameContainsAndRiotTagContains(riotName: String, riotTag: String): List<AccountEntity>
}