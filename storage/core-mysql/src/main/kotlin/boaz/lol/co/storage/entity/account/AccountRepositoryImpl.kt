package boaz.lol.co.storage.entity.account

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AccountRepositoryImpl(
    private val accountJpaRepository: AccountJpaRepository
): AccountRepository {
    override fun getById(id: Long): Optional<Account> {
        return accountJpaRepository.findById(id).map(AccountEntity::to);
    }

    override fun findByEmail(email: String): Optional<Account> {
        return accountJpaRepository.findByEmail(email).map(AccountEntity::to);
    }
}