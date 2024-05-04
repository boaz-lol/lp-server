package boaz.lol.co.application.exception

import boaz.lol.co.common.exception.CommonErrorCode
import boaz.lol.co.common.exception.ErrorCode
import boaz.lol.co.infrastructure.exception.RiotAccountException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionController : ResponseEntityExceptionHandler() {
    @ExceptionHandler(RestApiException::class)
    fun handleCustomException(e: RestApiException): ResponseEntity<Any> {
        val errorCode = e.getErrorCode()
        return handleExceptionInternal(errorCode)
    }

    @ExceptionHandler(RiotAccountException::class)
    fun handleRiotException(e: RiotAccountException): ResponseEntity<Any> {
        val errorCode = e.getErrorCode()
        return handleExceptionInternal(errorCode)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgument(e: IllegalArgumentException): ResponseEntity<Any> {
        val errorCode = CommonErrorCode.INVALID_PARAMETER
        return handleExceptionInternal(errorCode, e.message)
    }

    private fun handleExceptionInternal(errorCode: ErrorCode, message: String?): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.valueOf(errorCode.getCode())).body(makeErrorResponse(errorCode, message))
    }

    private fun makeErrorResponse(errorCode: ErrorCode, detail: String?): ErrorResponse {
        return ErrorResponse(errorCode.getCode(), errorCode.getMessage(), detail)
    }

    private fun makeErrorResponse(errorCode: ErrorCode): ErrorResponse {
        return ErrorResponse(errorCode.getCode(), errorCode.getMessage())
    }

    private fun handleExceptionInternal(errorCode: ErrorCode): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.valueOf(errorCode.getCode()))
            .body(makeErrorResponse(errorCode))
    }
}