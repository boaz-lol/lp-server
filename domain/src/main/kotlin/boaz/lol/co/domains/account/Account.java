package boaz.lol.co.domains.account;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Account {
    private final Long id;
    private final String email;
    private final String password;
    private final String riotName;
    private final String riotTag;
    private final String riotId;
    private final Boolean isAgreeToPersonalInfo;
    private final Boolean isAgreeToEmail;
    private final Boolean isCertificatedEmail;

    @Builder
    public Account(Long id, String email, String password, String riotName, String riotTag, String riotId, Boolean isAgreeToPersonalInfo, Boolean isAgreeToEmail, Boolean isCertificatedEmail) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.riotName = riotName;
        this.riotTag = riotTag;
        this.riotId = riotId;
        this.isAgreeToPersonalInfo = isAgreeToPersonalInfo;
        this.isAgreeToEmail = isAgreeToEmail;
        this.isCertificatedEmail = isCertificatedEmail;
    }
}
