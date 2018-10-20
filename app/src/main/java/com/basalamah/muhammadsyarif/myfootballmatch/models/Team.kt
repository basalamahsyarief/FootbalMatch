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
        @SerializedName("intLoved")
        var intLoved: String?,
        @SerializedName("intStadiumCapacity")
        var intStadiumCapacity: String?,
        @SerializedName("strAlternate")
        var strAlternate: String?,
        @SerializedName("strCountry")
        var strCountry: String?,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String?,
        @SerializedName("strDivision")
        var strDivision: String?,
        @SerializedName("strFacebook")
        var strFacebook: String?,
        @SerializedName("strGender")
        var strGender: String?,
        @SerializedName("strInstagram")
        var strInstagram: String?,
        @SerializedName("strKeywords")
        var strKeywords: String?,
        @SerializedName("strLeague")
        var strLeague: String?,
        @SerializedName("strLocked")
        var strLocked: String?,
        @SerializedName("strManager")
        var strManager: String?,
        @SerializedName("strRSS")
        var strRSS: String?,
        @SerializedName("strSport")
        var strSport: String?,
        @SerializedName("strStadium")
        var strStadium: String?,
        @SerializedName("strStadiumDescription")
        var strStadiumDescription: String?,
        @SerializedName("strStadiumLocation")
        var strStadiumLocation: String?,
        @SerializedName("strStadiumThumb")
        var strStadiumThumb: String?,
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