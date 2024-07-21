package boaz.lol.co.common.domain

data class Info(
    val endOfGameResult: String,
    val gameCreation: Long,
    val gameDuration: Int,
    val gameEndTimestamp: Long,
    val gameId: Long,
    val gameMode: String,
    val gameName: String,
    val gameStartTimestamp: Long,
    val gameType: String,
    val gameVersion: String,
    val mapId: Int,
    val participants: List<Participant>,
    val platformId: String,
    val queueId: Int,
    val tournamentCode: String?
)

data class Participant(
    val allInPings: Int,
    val assistMePings: Int,
    val assists: Int,
    val baronKills: Int,
    val basicPings: Int,
    val bountyLevel: Int,
    val challenges: Challenges,
    val championId: Int,
    val championName: String,
    val championTransform: Int,
    val commandPings: Int,
    val consumablesPurchased: Int,
    val damageDealtToBuildings: Int,
    val damageDealtToObjectives: Int,
    val damageDealtToTurrets: Int,
    val damageSelfMitigated: Int,
    val dangerPings: Int,
    val deaths: Int,
    val detectorWardsPlaced: Int,
    val doubleKills: Int,
    val dragonKills: Int,
    val eligibleForProgression: Boolean,
    val enemyMissingPings: Int,
    val enemyVisionPings: Int,
    val firstBloodAssist: Boolean,
    val firstBloodKill: Boolean,
    val firstTowerAssist: Boolean,
    val firstTowerKill: Boolean,
    val gameEndedInEarlySurrender: Boolean,
    val gameEndedInSurrender: Boolean,
    val getBackPings: Int,
    val goldEarned: Int,
    val goldSpent: Int,
    val holdPings: Int,
    val individualPosition: String,
    val inhibitorKills: Int,
    val inhibitorTakedowns: Int,
    val inhibitorsLost: Int,
    val item0: Int,
    val item1: Int,
    val item2: Int,
    val item3: Int,
    val item4: Int,
    val item5: Int,
    val item6: Int,
    val itemsPurchased: Int,
    val killingSprees: Int,
    val kills: Int,
    val lane: String,
    val largestCriticalStrike: Int,
    val largestKillingSpree: Int,
    val largestMultiKill: Int,
    val longestTimeSpentLiving: Int,
    val magicDamageDealt: Int,
    val magicDamageDealtToChampions: Int,
    val magicDamageTaken: Int,
    val missions: Missions,
    val needVisionPings: Int,
    val neutralMinionsKilled: Int,
    val nexusKills: Int,
    val nexusLost: Int,
    val nexusTakedowns: Int,
    val objectivesStolen: Int,
    val objectivesStolenAssists: Int,
    val onMyWayPings: Int,
    val participantId: Int,
    val pentaKills: Int,
    val physicalDamageDealt: Int,
    val physicalDamageDealtToChampions: Int,
    val physicalDamageTaken: Int,
    val placement: Int,
    val profileIcon: Int,
    val pushPings: Int,
    val puuid: String,
    val quadraKills: Int,
    val riotIdGameName: String,
    val riotIdTagline: String,
    val role: String,
    val sightWardsBoughtInGame: Int,
    val spell1Casts: Int,
    val spell2Casts: Int,
    val spell3Casts: Int,
    val spell4Casts: Int,
    val subteamPlacement: Int,
    val summoner1Casts: Int,
    val summoner1Id: Int,
    val summoner2Casts: Int,
    val summoner2Id: Int,
    val summonerId: String,
    val summonerLevel: Int,
    val summonerName: String,
    val teamEarlySurrendered: Boolean,
    val teamId: Int,
    val teamPosition: String,
    val timeCCingOthers: Int,
    val timePlayed: Int,
    val totalAllyJungleMinionsKilled: Int,
    val totalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val totalDamageShieldedOnTeammates: Int,
    val totalDamageTaken: Int,
    val totalEnemyJungleMinionsKilled: Int,
    val totalHeal: Int,
    val totalHealsOnTeammates: Int,
    val totalMinionsKilled: Int,
    val totalTimeCCDealt: Int,
    val totalTimeSpentDead: Int,
    val totalUnitsHealed: Int,
    val tripleKills: Int,
    val trueDamageDealt: Int,
    val trueDamageDealtToChampions: Int,
    val trueDamageTaken: Int,
    val turretKills: Int,
    val turretTakedowns: Int,
    val turretsLost: Int,
    val unrealKills: Int,
    val visionClearedPings: Int,
    val visionScore: Int,
    val visionWardsBoughtInGame: Int,
    val wardsKilled: Int,
    val wardsPlaced: Int,
    val win: Boolean
)
data class Challenges(
    val `12AssistStreakCount`: Int,
    val InfernalScalePickup: Int,
    val abilityUses: Int,
    val acesBefore15Minutes: Int,
    val alliedJungleMonsterKills: Int,
    val baronTakedowns: Int,
    val blastConeOppositeOpponentCount: Int,
    val bountyGold: Int,
    val buffsStolen: Int,
    val completeSupportQuestInTime: Int,
    val controlWardsPlaced: Int,
    val damagePerMinute: Double,
    val damageTakenOnTeamPercentage: Double,
    val dancedWithRiftHerald: Int,
    val deathsByEnemyChamps: Int,
    val dodgeSkillShotsSmallWindow: Int,
    val doubleAces: Int,
    val dragonTakedowns: Int,
    val earlyLaningPhaseGoldExpAdvantage: Int,
    val effectiveHealAndShielding: Int,
    val elderDragonKillsWithOpposingSoul: Int,
    val elderDragonMultikills: Int,
    val enemyChampionImmobilizations: Int,
    val enemyJungleMonsterKills: Int,
    val epicMonsterKillsNearEnemyJungler: Int,
    val epicMonsterKillsWithin30SecondsOfSpawn: Int,
    val epicMonsterSteals: Int,
    val epicMonsterStolenWithoutSmite: Int,
    val firstTurretKilled: Int,
    val fistBumpParticipation: Int,
    val flawlessAces: Int,
    val fullTeamTakedown: Int,
    val gameLength: Double,
    val getTakedownsInAllLanesEarlyJungleAsLaner: Int,
    val goldPerMinute: Double,
    val hadOpenNexus: Int,
    val immobilizeAndKillWithAlly: Int,
    val initialBuffCount: Int,
    val initialCrabCount: Int,
    val jungleCsBefore10Minutes: Int,
    val junglerTakedownsNearDamagedEpicMonster: Int,
    val kTurretsDestroyedBeforePlatesFall: Int,
    val kda: Double,
    val killAfterHiddenWithAlly: Int,
    val killParticipation: Double,
    val killedChampTookFullTeamDamageSurvived: Int,
    val killingSprees: Int,
    val killsNearEnemyTurret: Int,
    val killsOnOtherLanesEarlyJungleAsLaner: Int,
    val killsOnRecentlyHealedByAramPack: Int,
    val killsUnderOwnTurret: Int,
    val killsWithHelpFromEpicMonster: Int,
    val knockEnemyIntoTeamAndKill: Int,
    val landSkillShotsEarlyGame: Int,
    val laneMinionsFirst10Minutes: Int,
    val laningPhaseGoldExpAdvantage: Int,
    val legendaryCount: Int,
    val legendaryItemUsed: List<Int>,
    val lostAnInhibitor: Int,
    val maxCsAdvantageOnLaneOpponent: Int,
    val maxKillDeficit: Int,
    val maxLevelLeadLaneOpponent: Int,
    val mejaisFullStackInTime: Int,
    val moreEnemyJungleThanOpponent: Int,
    val multiKillOneSpell: Int,
    val multiTurretRiftHeraldCount: Int,
    val multikills: Int,
    val multikillsAfterAggressiveFlash: Int,
    val outerTurretExecutesBefore10Minutes: Int,
    val outnumberedKills: Int,
    val outnumberedNexusKill: Int,
    val perfectDragonSoulsTaken: Int,
    val perfectGame: Int,
    val pickKillWithAlly: Int,
    val playedChampSelectPosition: Int,
    val poroExplosions: Int,
    val quickCleanse: Int,
    val quickFirstTurret: Int,
    val quickSoloKills: Int,
    val riftHeraldTakedowns: Int,
    val saveAllyFromDeath: Int,
    val scuttleCrabKills: Int,
    val skillshotsDodged: Int,
    val skillshotsHit: Int,
    val snowballsHit: Int,
    val soloBaronKills: Int,
    val soloKills: Int,
    val stealthWardsPlaced: Int,
    val survivedSingleDigitHpCount: Int,
    val survivedThreeImmobilizesInFight: Int,
    val takedownOnFirstTurret: Int,
    val takedowns: Int,
    val takedownsAfterGainingLevelAdvantage: Int,
    val takedownsBeforeJungleMinionSpawn: Int,
    val takedownsFirstXMinutes: Int,
    val takedownsInAlcove: Int,
    val takedownsInEnemyFountain: Int,
    val teamBaronKills: Int,
    val teamDamagePercentage: Double,
    val teamElderDragonKills: Int,
    val teamRiftHeraldKills: Int,
    val tookLargeDamageSurvived: Int,
    val turretPlatesTaken: Int,
    val turretTakedowns: Int,
    val turretsTakenWithRiftHerald: Int,
    val twentyMinionsIn3SecondsCount: Int,
    val twoWardsOneSweeperCount: Int,
    val unseenRecalls: Int,
    val visionScoreAdvantageLaneOpponent: Double,
    val visionScorePerMinute: Double,
    val voidMonsterKill: Int,
    val wardTakedowns: Int,
    val wardTakedownsBefore20M: Int,
    val wardsGuarded: Int
)

data class Missions(
    val playerScore0: Int,
    val playerScore1: Int,
    val playerScore2: Int,
    val playerScore3: Int,
    val playerScore4: Int,
    val playerScore5: Int,
    val playerScore6: Int,
    val playerScore7: Int,
    val playerScore8: Int,
    val playerScore9: Int,
    val playerScore10: Int,
    val playerScore11: Int
)