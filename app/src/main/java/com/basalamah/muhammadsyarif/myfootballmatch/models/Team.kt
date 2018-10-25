package com.basalamah.muhammadsyarif.myfootballmatch.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TeamListResp(
        var teams:List<TeamResponse>?=null
)
@Parcelize
data class TeamResponse(
        @SerializedName("idLeague")
        var idLeague: String?,
        @SerializedName("idSoccerXML")
        var idSoccerXML: String?,
        @SerializedName("idTeam")
        var idTeam: String,
        @SerializedName("intFormedYear")
        var intFormedYear: String?,
        var strAlternate: String?,
        @SerializedName("strCountry")
        var strCountry: String?,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String?,
        @SerializedName("strStadium")
        var strStadium: String?,
        @SerializedName("strTeam")
        var strTeam: String?,
        @SerializedName("strTeamBadge")
        var strTeamBadge: String,
        @SerializedName("strTeamBanner")
        var strTeamBanner: String?,
        @SerializedName("strTeamJersey")
        var strTeamJersey: String?,
        @SerializedName("strTeamLogo")
        var strTeamLogo: String?
):Parcelable

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