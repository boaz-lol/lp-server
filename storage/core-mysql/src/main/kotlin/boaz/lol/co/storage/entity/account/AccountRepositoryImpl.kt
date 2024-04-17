package boaz.lol.co.storage.entity.account

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
class AccountRepositoryImpl(
    private val accountJpaRepository: AccountJpaRepository
): AccountRepository {
    @Transactional(readOnly = true)
    override fun getById(id: Long): Optional<Account> {
        return accountJpaRepository.findById(id).map(AccountEntity::to);
    }
}