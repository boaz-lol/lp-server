package boaz.lol.co.application.account.controller.dto

import boaz.lol.co.domains.account.Account
import boaz.lol.co.infrastructure.riot.RiotAccount

data class RiotAccountRes(
    val puuid: String,
    val gameName: String,
    val tagLine: String

    // TODO("전적 데이터 등 삽입")
) {
    companion object {
        fun from (account: RiotAccount) : RiotAccountRes {
            return RiotAccountRes(
                puuid = account.puuid,
                gameName = account.gameName,
                tagLine = account.tagLine
            )
        }

        fun from (account: Account) : RiotAccountRes {
            return RiotAccountRes(
                puuid = account.riotId,
                gameName = account.riotName,
                tagLine = account.riotTag
            )
        }
    }
}