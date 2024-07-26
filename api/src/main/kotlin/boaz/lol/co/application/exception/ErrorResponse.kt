package boaz.lol.co.application.exception

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.validation.FieldError


data class ErrorResponse(
    val code: Int,
    val message: String?,
    val detail: String? = null
)