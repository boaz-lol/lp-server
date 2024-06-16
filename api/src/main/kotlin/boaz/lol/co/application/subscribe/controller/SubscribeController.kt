package boaz.lol.co.application.subscribe.controller

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.application.subscribe.service.SubscribeService
import boaz.lol.co.domains.account.AccountData
import boaz.lol.co.resolver.AuthAccountData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscriptions")
class SubscribeController(private val subscribeService: SubscribeService) {

    @PostMapping
    fun subscription(
        @RequestBody req: SubscribeReq,
        @AuthAccountData accountData: AccountData
    ): ResponseEntity<String> {
        subscribeService.like(req, accountData)
        return ResponseEntity.status(HttpStatus.OK).body("구독이 성공적으로 업데이트 되었습니다.")
    }
}
