package boaz.lol.co.application.exception

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.validation.FieldError


data class ErrorResponse(
    val code: Int,
    val message: String?,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val errors: List<ValidationError> = emptyList()
) {
    data class ValidationError(
        val field: String,
        val message: String
    ) {
        companion object {
            fun of(fieldError: FieldError): ValidationError {
                return ValidationError(fieldError.field, fieldError.defaultMessage ?: "")
            }
        }
    }
}