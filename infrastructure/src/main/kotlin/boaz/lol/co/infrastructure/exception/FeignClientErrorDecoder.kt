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
        val error = parse(response)
        error?.status?.let {
            return IllegalArgumentException(error.status.message)
        }
        return ErrorDecoder.Default().decode(methodKey, response)
    }

    private fun parse(response: Response): RiotCommonError? {
        return runCatching {
            objectMapper.readValue(response.body().asInputStream(), RiotCommonError::class.java)
        }.getOrNull()
    }
}