package boaz.lol.co.domains.version

import java.time.LocalDate

data class PatchVersion(
    val number: String,
    val subVersion: String,
    val expectedAt: LocalDate,
    val appliedAt: LocalDate
)