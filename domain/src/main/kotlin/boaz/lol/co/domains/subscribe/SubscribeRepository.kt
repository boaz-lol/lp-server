package boaz.lol.co.domains.subscribe

import boaz.lol.co.domains.account.Account
import boaz.lol.co.domains.champion.Champion

interface SubscribeRepository {
    fun getByAccount(account: Account) : Subscribe
    fun addSubscribe(account: Account, champion: Champion)
    fun deleteSubscribe(account: Account, champion: Champion)
    fun getAccountsByChampions(champions: List<Champion>): List<Account>
}