package boaz.lol.co.application.exception


class RestApiException(private val e: ErrorCode) : RuntimeException() {
    fun getErrorCode(): ErrorCode {
        return e
    }
}