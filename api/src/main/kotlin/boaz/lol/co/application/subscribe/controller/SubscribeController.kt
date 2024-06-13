package boaz.lol.co.application.subscribe.controller

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.application.subscribe.service.SubscribeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subscribe")
class SubscribeController(private val subscribeService: SubscribeService) {

    @PostMapping("/add")
    fun addSubscription(@RequestBody req: SubscribeReq): ResponseEntity<String> {
        subscribeService.addSubscription(req)
        return ResponseEntity.status(HttpStatus.CREATED).body("구독 완료")
    }

    @PostMapping("/remove")
    fun removeSubscription(@RequestBody req: SubscribeReq): ResponseEntity<String> {
        subscribeService.removeSubscription(req)
        return ResponseEntity.status(HttpStatus.OK).body("구독 취소 완료")
    }
}
