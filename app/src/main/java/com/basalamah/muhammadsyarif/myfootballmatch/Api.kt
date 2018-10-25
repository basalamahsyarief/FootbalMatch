package com.basalamah.muhammadsyarif.myfootballmatch

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamBadges
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamListResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @GET("eventspastleague.php?id=4328")
    fun getPastLeague():Call<EventListResp>
    @GET("eventsnextleague.php?id=4328")
    fun getNextLeague():Call<EventListResp>
    @POST("searchteams.php?")
    fun getBadge(@Query("t")team: String):Call<TeamBadges>
    @POST("lookupevent.php?")
    fun getDetailEvent(@Query("id")idEvent:String):Call<EventListResp>
    @POST("lookup_all_teams.php")
    fun getListTeams(@Query("id")idEvent:String):Call<TeamListResp>
    @GET("lookup_all_players.php")
    fun getPlayers(@Query("id") id:String?) : Call<PlayerListResp>
}