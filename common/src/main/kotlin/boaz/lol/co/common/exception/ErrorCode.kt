package boaz.lol.co.common.exception

interface ErrorCode {
    fun getCode(): Int
    fun getHttpStatus(): HttpStatus
    fun getMessage(): String
}