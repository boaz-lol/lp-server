package boaz.lol.co.application.exception

import boaz.lol.co.common.exception.ErrorCode


class RestApiException(private val e: ErrorCode) : RuntimeException() {
    fun getErrorCode(): ErrorCode {
        return e
    }
}