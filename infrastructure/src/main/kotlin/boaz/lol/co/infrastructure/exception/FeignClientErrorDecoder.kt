package boaz.lol.co.infrastructure.exception

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class FeignClientErrorDecoder (
    private val objectMapper: ObjectMapper = jacksonObjectMapper().findAndRegisterModules()
) : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() == 404) {
            throw IllegalArgumentException("No User")
        }
        return ErrorDecoder.Default().decode(methodKey, response)
    }
}