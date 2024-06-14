package boaz.lol.co.application.subscribe.controller

import boaz.lol.co.application.subscribe.dto.*
import boaz.lol.co.application.subscribe.service.SubscribeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notifies")
class EmailController(
    private val subscribeService: SubscribeService
) {

    @PostMapping
    fun sendNotifications(@RequestBody req: EmailReq): ResponseEntity<String> {
        subscribeService.notify(req.champions)
        return ResponseEntity.status(HttpStatus.OK).body("이메일 알림이 성공적으로 발송되었습니다.")
    }
}
