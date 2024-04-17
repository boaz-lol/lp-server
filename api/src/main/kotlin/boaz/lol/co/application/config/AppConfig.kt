package boaz.lol.co.application.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("boaz.lol.co.domains")
@ComponentScan("boaz.lol.co.storage")
class AppConfig