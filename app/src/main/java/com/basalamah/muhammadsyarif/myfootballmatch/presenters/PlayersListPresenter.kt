package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.util.Log.e
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerListResp
import com.basalamah.muhammadsyarif.myfootballmatch.view.PlayerListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersListPresenter (private val view : PlayerListView) {
    fun getDataListPlayer(id: String?){
        MyApplication.api.getPlayers(id).enqueue(object : Callback<PlayerListResp>{
            override fun onFailure(call: Call<PlayerListResp>, t: Throwable) {
                e("Error Parsing","{${t.message}")
            }

            override fun onResponse(call: Call<PlayerListResp>, response: Response<PlayerListResp>) {
                val nPlayerListResp = response.body()?.player
                nPlayerListResp.let {
                    view.showListPlayer(it)
                }
            }

        })
    }
}