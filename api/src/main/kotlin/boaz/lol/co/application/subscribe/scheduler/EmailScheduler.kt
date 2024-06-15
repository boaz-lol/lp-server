package boaz.lol.co.application.scheduler

import boaz.lol.co.application.subscribe.service.SubscribeService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EmailScheduler(
    private val subscribeService: SubscribeService,
) {

    @Scheduled(cron = "0 0 * * * ?")
    fun scheduleEmailUpdates() {

    }
}
