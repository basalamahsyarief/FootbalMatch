package com.basalamah.muhammadsyarif.myfootballmatch.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class EventListResp(
        val events: List<EventResponse>? = null
)

data class TeamBadges(
        @field:SerializedName("teams")
        val listTeams: List<BadgeResponse>? = null
)

data class BadgeResponse(
        @field:SerializedName("strTeamBadge")
        val badge: String? = ""
)

@Parcelize
data class EventResponse(
        val id: Long?,
        val idEvent: String? = "",
        val strDate: String? = "",
        val strTime: String? = "",
        val strHomeTeam: String? = "",
        val strAwayTeam: String? = "",
        val intHomeScore: String? = "",
        val intAwayScore: String? = "",
        val strHomeRedCards: String? = "",
        val strHomeYellowCards: String? = "",
        val strAwayRedCards: String? = "",
        val strAwayYellowCards: String? = ""
) : Parcelable {
    companion object {
        const val TABLE = "TABLE_MATCH"
        const val ID = "ID_"
        const val EVENT_ID = "EVENT_ID"
        const val STR_DATE = "STR_DATE"
        const val STR_TIME = "STR_TIME"
        const val HOME_TEAM = "HOME_TEAM"
        const val AWAY_TEAM = "AWAY_TEAM"
        const val SCORE_HOME = "SCORE_HOME"
        const val SCORE_AWAY = "SCORE_AWAY"
        const val AWAY_YELLOW = "YELLOW_AWAY"
        const val HOME_YELLOW = "YELLOW_HOME"
        const val AWAY_RED = "AWAY_RED"
        const val HOME_RED = "HOME_RED"
    }
}
