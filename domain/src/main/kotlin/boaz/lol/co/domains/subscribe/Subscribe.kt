package boaz.lol.co.domains.subscribe

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.champion.Champion

data class Subscribe (
    val account: Account,
    val champions: List<Champion>
) {

    fun toSubscribeData(): SubscribeData {
        return SubscribeData(
            accountId = this.account.id,
            championIds = this.champions.map { it.id }
        )
    }
}