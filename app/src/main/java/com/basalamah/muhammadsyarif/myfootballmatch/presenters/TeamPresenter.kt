package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.util.Log
import android.util.Log.i
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamListResp
import com.basalamah.muhammadsyarif.myfootballmatch.view.TeamView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamPresenter(private val view:TeamView) {

    fun getTeamList(idEvent:String){
        MyApplication.api.getListTeams(idEvent).enqueue(object : Callback<TeamListResp>{
            override fun onFailure(call: Call<TeamListResp>, t: Throwable) {
                Log.i("TAG", t.message)
            }

            override fun onResponse(call: Call<TeamListResp>, response: Response<TeamListResp>) {
                i("data","${Gson().toJsonTree(response.body())}")
                val nTeamList = response.body()?.teams
                nTeamList?.let {
                    view.showTeam(it)
                }
            }

        })
    }
}