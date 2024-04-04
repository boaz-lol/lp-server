package boaz.lol.co.domains.account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> getById(long id);
}
