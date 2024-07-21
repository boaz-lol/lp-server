package boaz.lol.co.infrastructure.riot

import boaz.lol.co.common.domain.Info
import boaz.lol.co.common.domain.Metadata
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class RiotMatch (
    val metadata: Metadata,
    val info: Info
)
