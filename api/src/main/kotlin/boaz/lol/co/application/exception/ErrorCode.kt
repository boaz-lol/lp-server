package boaz.lol.co.application.exception

import org.springframework.http.HttpStatus

interface ErrorCode {
    fun getCode(): Int
    fun getHttpStatus(): HttpStatus
    fun getMessage(): String
}