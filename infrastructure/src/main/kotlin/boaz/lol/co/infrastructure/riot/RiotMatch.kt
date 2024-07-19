package boaz.lol.co.infrastructure.riot

import boaz.lol.co.common.domain.Info
import boaz.lol.co.common.domain.Metadata

data class RiotMatch (
    val metadata: Metadata,
    val info: Info
)
