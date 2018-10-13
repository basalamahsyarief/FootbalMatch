package com.basalamah.muhammadsyarif.myfootballmatch

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {
    companion object {
        lateinit var api:Api
    }
    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(Api::class.java)
    }
}