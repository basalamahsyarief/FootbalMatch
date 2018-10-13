package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.util.Log
import android.util.Log.e
import android.util.Log.i
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.basalamah.muhammadsyarif.myfootballmatch.view.DetailView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(private val event: DetailView) {

    fun getDetail(idEvent:String){
        MyApplication.api.getDetailEvent(idEvent).enqueue(object :Callback<EventListResp>{
            override fun onFailure(call: Call<EventListResp>?, t: Throwable?) {
                e("error",t?.message)
            }

            override fun onResponse(call: Call<EventListResp>?, response: Response<EventListResp>?) {
                i("hasil:","${response?.body()}")
                event.showDetail(response?.body()?.events?.get(0))
            }

        })
    }
    fun getDataImage(name:String, team:String){
        MyApplication.api.getBadge(name).enqueue(object : Callback<TeamResponse>{
            override fun onFailure(call: Call<TeamResponse>?, t: Throwable?) {
                Log.i("TAG", t?.message)
            }

            override fun onResponse(call: Call<TeamResponse>?, response: Response<TeamResponse>?) {
                if(team.equals("home")){
                    event.showBadgeHome(response?.body())
                }else{
                    event.showBadgeAway(response?.body())
                }
            }

        })
    }
}