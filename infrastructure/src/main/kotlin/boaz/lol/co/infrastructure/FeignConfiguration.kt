package boaz.lol.co.infrastructure

import boaz.lol.co.infrastructure.exception.FeignClientErrorDecoder
import feign.codec.Decoder
import feign.codec.ErrorDecoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
@EnableFeignClients(basePackages = ["boaz.lol.co.infrastructure"])
class FeignConfiguration {
    @Bean
    fun errorDecoder(): ErrorDecoder {
        return FeignClientErrorDecoder()
    }
}