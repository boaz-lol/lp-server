package boaz.lol.co.infrastructure

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["boaz.lol.co.infrastructure"])
class FeignConfiguration