package com.basalamah.muhammadsyarif.myfootballmatch.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TeamListResp(
        var teams:List<TeamResponse>?=null
)
@Parcelize
data class TeamResponse(
        val id:Long?,
        val idTeam: String="",
        val intFormedYear: String?="",
        val strCountry: String?="",
        val strDescriptionEN: String?="",
        val strStadium: String?="",
        val strTeam: String?="",
        val strTeamBadge: String="",
        val strTeamBanner: String?="",
        val strTeamLogo: String?=""
):Parcelable{
    companion object {
        const val TABLE = "TABLE_TEAM"
        const val ID = "ID_"
        const val ID_TEAM = "ID_TEAM"
        const val INT_FORMED_YEAR = "INT_FORMED_YEAR"
        const val STR_COUNTRY = "STR_COUNTRY"
        const val STR_DESC_EN = "STR_DESC_EN"
        const val STR_STADIUM = "STR_STADIUM"
        const val STR_TEAM = "STR_TEAM"
        const val STR_TEAM_BADGE="STR_TEAM_BADGE"
        const val STR_TEAM_BANNER="STR_TEAM_BANNER"
        const val STR_TEAM_LOGO = "STR_TEAM_LOGO"
    }
}


data class PlayerListResp(
        var player:List<PlayerResponse>?=null
)
@Parcelize
data class PlayerResponse(
        @SerializedName("dateBorn")
        var dateBorn: String?,
        @SerializedName("dateSigned")
        var dateSigned: String?,
        @SerializedName("idPlayer")
        var idPlayer: String,
        @SerializedName("idPlayerManager")
        var idPlayerManager: String?,
        @SerializedName("idTeam")
        var idTeam: String?,
        @SerializedName("strBirthLocation")
        var strBirthLocation: String?,
        @SerializedName("strCollege")
        var strCollege: String?,
        @SerializedName("strCutout")
        var strCutout: String?,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String?,
        @SerializedName("strHeight")
        var strHeight: String?,
        @SerializedName("strNationality")
        var strNationality: String?,
        @SerializedName("strPlayer")
        var strPlayer: String?,
        @SerializedName("strPosition")
        var strPosition: String?,
        @SerializedName("strSigning")
        var strSigning: String?,
        @SerializedName("strTeam")
        var strTeam: String?,
        @SerializedName("strThumb")
        var strThumb: String?,
        @SerializedName("strWeight")
        var strWeight: String?,
        @SerializedName("strFanart1")
        var strFanart1: String?
): Parcelable
