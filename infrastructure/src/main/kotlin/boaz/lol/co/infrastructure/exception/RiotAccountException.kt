package boaz.lol.co.infrastructure.exception

import boaz.lol.co.common.exception.ErrorCode


class RiotAccountException(private val e: ErrorCode) : RuntimeException() {
    fun getErrorCode(): ErrorCode {
        return e
    }
}