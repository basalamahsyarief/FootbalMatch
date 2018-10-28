package com.basalamah.muhammadsyarif.myfootballmatch

import com.basalamah.muhammadsyarif.myfootballmatch.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("eventspastleague.php?")
    fun getPastLeague(@Query("id")idEvent:String):Call<EventListResp>
    @POST("eventsnextleague.php?")
    fun getNextLeague(@Query("id")idEvent:String):Call<EventListResp>
    @POST("searchteams.php?")
    fun getBadge(@Query("t")team: String):Call<TeamBadges>
    @POST("lookupevent.php?")
    fun getDetailEvent(@Query("id")idEvent:String):Call<EventListResp>
    @POST("lookup_all_teams.php")
    fun getListTeams(@Query("id")idEvent:String):Call<TeamListResp>
    @GET("lookup_all_players.php")
    fun getPlayers(@Query("id") id:String?) : Call<PlayerListResp>
    @POST("lookupteam.php")
    fun getTeam(@Query("id") id:String?) : Call<TeamListResp>
}