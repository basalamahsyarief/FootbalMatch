package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.content.Context
import android.util.Log
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.database
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import com.google.gson.Gson
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val view: EventNextView){

    fun getDataEventNext(){
        MyApplication.api.getNextLeague().enqueue(object : Callback<EventListResp> {
            override fun onFailure(call: Call<EventListResp>?, t: Throwable?) {
                Log.e("TAG", t?.message)
            }

            override fun onResponse(call: Call<EventListResp>?, response: Response<EventListResp>?) {
                Log.i("TAG", "${Gson().toJsonTree(response?.body())}")
                val nEventList = response?.body()?.events
                nEventList?.let {
                    view.showEventList(nEventList)
                }
            }

        })
    }


    fun getDataPast(){
        MyApplication.api.getPastLeague().enqueue(object : Callback<EventListResp> {
            override fun onFailure(call: Call<EventListResp>?, t: Throwable?) {
                Log.e("TAG", t?.message)
            }

            override fun onResponse(call: Call<EventListResp>?, response: Response<EventListResp>?) {
                Log.i("TAG", "${Gson().toJsonTree(response?.body())}")
                val nEventList = response?.body()?.events
                nEventList?.let {
                    view.showEventList(nEventList)
                }
            }

        })
    }
}