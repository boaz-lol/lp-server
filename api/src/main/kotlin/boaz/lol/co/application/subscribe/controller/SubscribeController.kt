package boaz.lol.co.application.subscribe.controller

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.application.subscribe.service.SubscribeService
import boaz.lol.co.domains.account.AccountData
import boaz.lol.co.resolver.AuthAccountData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscribtions")
class SubscribeController(private val subscribeService: SubscribeService) {

    @PostMapping
    fun handleSubscription(
        @RequestBody req: SubscribeReq,
        @AuthAccountData accountData: AccountData
    ): ResponseEntity<String> {
        subscribeService.Subscription(req, accountData)
        return ResponseEntity.status(HttpStatus.OK).body(
            when (req.action.lowercase()) {
                "add" -> "구독 완료"
                "remove" -> "구독 취소 완료"
                else -> "잘못된 요청"
            }
        )
    }
}
