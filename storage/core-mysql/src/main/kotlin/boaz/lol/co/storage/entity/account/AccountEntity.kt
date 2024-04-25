package boaz.lol.co.storage.entity.account

import boaz.lol.co.storage.common.BaseEntity
import boaz.lol.co.domains.account.Account
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="account")
class AccountEntity(
    @Column
    val email: String,

    @Column
    val password: String,

    @Column
    val riotName: String,

    @Column
    val riotTag: String,

    @Column
    val riotId: String,

    @Column
    val isAgreeToPersonalInfo: Boolean = false,

    @Column
    val isAgreeToEmail: Boolean = false,

    @Column
    val isCertificatedEmail: Boolean = false
) : BaseEntity() {
    fun to(): Account {
        return Account(id, email, password, riotName, riotTag, riotId, isAgreeToPersonalInfo, isAgreeToEmail, isCertificatedEmail)
    }

    constructor(account: Account) : this(
        email = account.email,
        password = account.password,
        riotName = account.riotName,
        riotTag = account.riotTag,
        riotId = account.riotId,
        isAgreeToPersonalInfo = account.isAgreeToPersonalInfo,
        isAgreeToEmail = account.isAgreeToEmail,
        isCertificatedEmail = account.isCertificatedEmail
    )

}