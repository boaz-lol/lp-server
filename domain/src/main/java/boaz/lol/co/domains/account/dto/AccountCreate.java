package boaz.lol.co.domains.account.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountCreate {
    private final String email;
    private final String password;

    @Builder
    public AccountCreate(
            String email,
            String password
    ) {
        this.email = email;
        this.password = password;
    }
}
