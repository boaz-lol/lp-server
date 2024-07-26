package boaz.lol.co.infrastructure.exception

import com.fasterxml.jackson.annotation.JsonProperty

data class RiotCommonError(
    @JsonProperty("status")
    val status: Status
)

data class Status(
    @JsonProperty("status_code")
    val statusCode: Int,
    @JsonProperty("message")
    val message: String
)

