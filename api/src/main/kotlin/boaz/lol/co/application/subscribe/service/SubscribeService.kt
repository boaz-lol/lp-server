package boaz.lol.co.application.subscribe.service

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.domains.account.*
import boaz.lol.co.domains.champion.*
import boaz.lol.co.domains.subscribe.*
import org.springframework.stereotype.Service

@Service
class SubscribeService(
    private val subscribeRepository: SubscribeRepository,
    private val accountRepository: AccountRepository,
    private val championRepository: ChampionRepository,
) {


    fun like(req: SubscribeReq, accountData: AccountData) {
        val account = accountRepository.getById(accountData.id).orElseThrow()
        val champion = championRepository.getById(req.championId).orElseThrow()

        if (req.subscribe) {
            subscribeRepository.addSubscribe(account, champion)
        } else {
            subscribeRepository.deleteSubscribe(account, champion)
        }
    }


//    fun notify(champions: List<Champion>) {
//        val accounts = subscribeRepository.getAccountsByChampions(champions)
//        accounts.forEach { account ->
//            emailService.sendChampionUpdateNotification(
//                account.email,
//                champions.map { it.name }.joinToString(", "),
//                "업데이트 챔피언: ${champions.joinToString { it.name }}"
//            )
//        }
//    }
}
