package boaz.lol.co.entity.account

import boaz.lol.co.common.BaseEntity
import boaz.lol.co.domains.account.Account
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
    var isAgreeToPersonalInfo: Boolean = false,

    @Column
    var isAgreeToEmail: Boolean = false,

    @Column
    var isCertificatedEMail: Boolean = false
) : BaseEntity() {
    fun to(): Account {
        return Account(id, email, password, riotName, riotTag, riotId, isAgreeToPersonalInfo, isAgreeToEmail, isCertificatedEMail)
    }
}