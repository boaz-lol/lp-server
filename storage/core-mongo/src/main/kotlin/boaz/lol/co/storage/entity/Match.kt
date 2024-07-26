package boaz.lol.co.storage.entity

import boaz.lol.co.common.domain.Info
import boaz.lol.co.common.domain.Metadata
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "matches")
data class Match (
    val metadata: Metadata,
    val info: Info
)