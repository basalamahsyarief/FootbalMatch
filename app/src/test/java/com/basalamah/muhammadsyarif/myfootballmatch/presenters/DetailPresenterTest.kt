package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import com.basalamah.muhammadsyarif.myfootballmatch.Api
import com.basalamah.muhammadsyarif.myfootballmatch.MyApplication
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.view.DetailView
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailPresenterTest {

    @Mock
    private lateinit var view:DetailView

    @Mock
    private lateinit var presenter: DetailPresenter

    @Before
    fun setupEnv(){
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view)
    }

    @Test
    fun unitDetail() {
        val id = "576549"
        val data: MutableList<EventResponse> = mutableListOf()
        val myresponse = EventListResp(data)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        MyApplication.api = retrofit.create(Api::class.java)
        MyApplication.api.getDetailEvent(id).enqueue(object : Callback<EventListResp>{
            override fun onFailure(call: Call<EventListResp>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<EventListResp>, response: Response<EventListResp>) {
                Mockito.`when`(response.body()).thenReturn(myresponse)
                val nList = response.body()?.events
                verify(view).showDetail(nList?.get(0))
            }
        })
    }
}