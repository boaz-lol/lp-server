package boaz.lol.co.application.subscribe.service

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.domains.account.*
import boaz.lol.co.domains.champion.*
import boaz.lol.co.domains.subscribe.*
import boaz.lol.co.application.subscribe.EmailService
import org.springframework.stereotype.Service

@Service
class SubscribeService(
    private val subscribeRepository: SubscribeRepository,
    private val accountRepository: AccountRepository,
    private val championRepository: ChampionRepository,
    private val emailService: EmailService
) {

    fun addSubscription(req: SubscribeReq) {
        val account = accountRepository.getById(req.accountId).orElseThrow()
        val champion = championRepository.getById(req.championId).orElseThrow()
        subscribeRepository.addSubscribe(account, champion)
    }

    fun removeSubscription(req: SubscribeReq) {
        val account = accountRepository.getById(req.accountId).orElseThrow()
        val champion = championRepository.getById(req.championId).orElseThrow()
        subscribeRepository.deleteSubscribe(account, champion)
    }

    fun getSubscribeData(accountId: Long): SubscribeData {
        val account = accountRepository.getById(accountId).orElseThrow()
        val subscribe = subscribeRepository.getByAccount(account)
        return subscribe.toSubscribeData()
    }

    fun notify(champions: List<Champion>) {
        val accounts = subscribeRepository.getAccountsByChampions(champions)
        accounts.forEach { account ->
            emailService.sendChampionUpdateNotification(
                account.email,
                champions.map { it.name }.joinToString(", "),
                "업데이트 된 챔피언: ${champions.joinToString { it.name }}"
            )
        }
    }
}
