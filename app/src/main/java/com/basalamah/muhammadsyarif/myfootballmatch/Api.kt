package com.basalamah.muhammadsyarif.myfootballmatch

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
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
    fun getBadge(@Query("t")team: String):Call<TeamResponse>
    @POST("lookupevent.php?")
    fun getDetailEvent(@Query("id")idEvent:String):Call<EventListResp>
}