package boaz.lol.co.application.subscribe.service

import boaz.lol.co.application.subscribe.config.EmailConfig
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val mailSender: JavaMailSender,
    private val emailConfig: EmailConfig
) {

    fun sendChampionUpdateNotification(to: String, championNames: String, updateDetails: String) {
        val subject = "업데이트 챔피언: $championNames"
        val text = "패치 사항:\n\n$updateDetails"
        val message = SimpleMailMessage()
        message.setTo(to)
        message.setFrom(emailConfig.username)
        message.setSubject(subject)
        message.setText(text)
        mailSender.send(message)
    }
}