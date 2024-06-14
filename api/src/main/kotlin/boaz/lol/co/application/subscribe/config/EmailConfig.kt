package boaz.lol.co.application.subscribe.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "brevo.smtp")
data class EmailConfig(
    var host: String = "",
    var port: Int = 587,
    var username: String = "",
    var password: String = ""
)
