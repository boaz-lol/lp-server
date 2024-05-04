package boaz.lol.co.common.exception

enum class HttpStatus (
    private val value: Int,
    private val status: String
) {
    OK(200, "OK"),
    CREATED(201, "CREATED"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR");
}