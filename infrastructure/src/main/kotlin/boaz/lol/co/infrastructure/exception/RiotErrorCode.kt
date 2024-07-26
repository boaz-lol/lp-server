package boaz.lol.co.infrastructure.exception

import boaz.lol.co.common.exception.ErrorCode
import boaz.lol.co.common.exception.HttpStatus

enum class RiotErrorCode (
    private val code: Int,
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorCode {
    USER_NOT_FOUND(404, HttpStatus.NOT_FOUND, "Riot Account Not Found");
    override fun getCode(): Int {
        return code
    }
    override fun getHttpStatus(): HttpStatus {
        return httpStatus
    }

    override fun getMessage(): String {
        return message
    }
}