package boaz.lol.co.storage.entity.account

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountCreate
import boaz.lol.co.domains.account.AccountRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AccountRepositoryImpl(
    private val accountJpaRepository: AccountJpaRepository
): AccountRepository {
    override fun getById(id: Long): Optional<Account> {
        return accountJpaRepository.findById(id).map(AccountEntity::to)
    }

    override fun getByEmail(email: String): Optional<Account> {
        return accountJpaRepository.findByEmail(email).map(AccountEntity::to)
    }

    override fun existByEmail(email: String): Boolean {
        return accountJpaRepository.existsByEmail(email)
    }

    override fun add(account: AccountCreate): Account {
        return accountJpaRepository.save(AccountEntity(account)).to();
    }
}