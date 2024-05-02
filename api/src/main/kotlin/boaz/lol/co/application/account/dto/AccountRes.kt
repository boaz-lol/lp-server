package boaz.lol.co.application.account.dto

import boaz.lol.co.domains.account.Account

data class AccountRes(
    val id: Long,
    val email: String,
    val riotName: String,
    val riotTag: String,
    val riotId: String,
    val isAgreeToPersonalInfo: Boolean,
    val isAgreeToEmail: Boolean,
    val isCertificatedEmail: Boolean
) {
    companion object {
        fun from(account: Account) : AccountRes {
            return AccountRes(
                id = account.id,
                email = account.email,
                riotName = account.riotName,
                riotTag = account.riotTag,
                riotId = account.riotId,
                isAgreeToPersonalInfo = account.isAgreeToPersonalInfo,
                isAgreeToEmail = account.isAgreeToEmail,
                isCertificatedEmail = account.isCertificatedEmail
            )
        }
    }
}