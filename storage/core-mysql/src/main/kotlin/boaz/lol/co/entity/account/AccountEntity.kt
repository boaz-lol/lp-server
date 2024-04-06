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
    val isCertificatedEMail: Boolean = false
) : BaseEntity() {
    fun to(): Account {
        return Account(id!!, email, password, riotName, riotTag, riotId, isAgreeToPersonalInfo, isAgreeToEmail, isCertificatedEMail)
    }
}