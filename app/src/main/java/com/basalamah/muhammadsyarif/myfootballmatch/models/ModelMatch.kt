package com.basalamah.muhammadsyarif.myfootballmatch.models

import com.google.gson.annotations.SerializedName

data class EventListResp(
        val events:List<EventResponse>?=null
)
data class TeamResponse(
        @field:SerializedName("teams")
        val listTeams:List<badgeResponse>?=null
)
data class badgeResponse(
        @field:SerializedName("strTeamBadge")
        val badge:String?=""
)
data class EventResponse(
        val id:Long?,
        val idEvent:String?="",
        val dateEvent:String?="",
        val strHomeTeam:String?="",
        val strAwayTeam:String?="",
        val intHomeScore:String?="",
        val intAwayScore:String?="",
        val strHomeRedCards:String?="",
        val strHomeYellowCards:String?="",
        val strAwayRedCards:String?="",
        val strAwayYellowCards:String?=""
){
        companion object {
                const val TABLE = "TABLE_FAV"
                const val ID = "ID_"
                const val EVENT_ID = "EVENT_ID"
                const val EVENT_DATE = "EVENT_DATE"
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
