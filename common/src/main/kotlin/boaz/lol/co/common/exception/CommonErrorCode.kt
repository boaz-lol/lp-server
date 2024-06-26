package boaz.lol.co.common.exception

enum class CommonErrorCode(
    private val code: Int,
    private val httpStatus: HttpStatus,
    private val message: String
) : ErrorCode {
    INVALID_PARAMETER(400, HttpStatus.BAD_REQUEST, "Invalid parameter included"),
    RESOURCE_NOT_FOUND(404, HttpStatus.NOT_FOUND, "Resource not exists"),
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");

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