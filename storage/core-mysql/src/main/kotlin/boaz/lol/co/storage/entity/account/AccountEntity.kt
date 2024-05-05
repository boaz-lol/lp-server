package boaz.lol.co.storage.entity.account

import boaz.lol.co.storage.common.BaseEntity
import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.account.AccountCreate
import boaz.lol.co.domains.account.AccountModify
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="account")
class AccountEntity(
    @Column
    var email: String,

    @Column
    var password: String,

    @Column
    var riotName: String,

    @Column
    var riotTag: String,

    @Column
    var riotId: String,

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
        isCertificatedEmail = account.isCertificatedEmail,
    )

    constructor(account: AccountCreate) : this(
        email = account.email,
        password = account.password,
        riotName = account.riotName,
        riotTag = account.riotTag,
        riotId = account.riotId,
        isAgreeToPersonalInfo = account.isAgreeToPersonalInfo,
        isAgreeToEmail = account.isAgreeToEmail,
        isCertificatedEmail = account.isCertificatedEmail
    )

    fun update(accountModify: AccountModify) {
        this.email = accountModify.email
        this.riotName = accountModify.riotName
        this.riotTag = accountModify.riotTag
        this.riotId = accountModify.riotId
    }

}