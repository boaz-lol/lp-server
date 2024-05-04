package boaz.lol.co.infrastructure

import boaz.lol.co.infrastructure.exception.FeignClientErrorDecoder
import feign.codec.ErrorDecoder
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["boaz.lol.co.infrastructure"])
class FeignConfiguration {
    @Bean
    fun errorDecoder() : ErrorDecoder {
        return FeignClientErrorDecoder();
    }
}