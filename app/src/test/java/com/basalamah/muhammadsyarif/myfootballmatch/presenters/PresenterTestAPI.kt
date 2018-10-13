package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.util.Log
import com.basalamah.muhammadsyarif.myfootballmatch.Api
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PresenterTestAPI {
    @Mock
    private
    lateinit var view:EventNextView

    @Mock
    private
    lateinit var presenter: Presenter


    @Before
    fun setupEnv(){
        MockitoAnnotations.initMocks(this)
        presenter = Presenter(view)
    }

    @Test
    fun nextListApi(){
        val classEvent = Mockito.mock(Presenter::class.java)
        classEvent.getDataEventNext()
        verify(classEvent).getDataEventNext()
    }
    @Test
    fun listMatchPast(){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        MyApplication.api = retrofit.create(Api::class.java)
        MyApplication.api.getPastLeague().enqueue(object : Callback<EventListResp>{
            override fun onFailure(call: Call<EventListResp>?, t: Throwable?) {
                Log.e("TAG", t?.message)
            }

            override fun onResponse(call: Call<EventListResp>?, response: Response<EventListResp>?) {
                val nEventList = response?.body()?.events
                nEventList?.let {
                    verify(view).showEventList(nEventList)
                }
            }

        })
    }
}