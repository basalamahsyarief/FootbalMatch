package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.Presenter
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.EventAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import kotlinx.android.synthetic.main.fragment_past.*

class PastFragment : Fragment(), EventNextView {

    private val evenList = mutableListOf<EventResponse>()
    private lateinit var adapter: EventAdapter
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = Presenter(this)
        presenter.getDataPast()

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EventAdapter(evenList)
        rvPast.adapter = adapter
        rvPast.layoutManager = LinearLayoutManager(context)
    }
//    private fun getData(){
//        MyApplication.api.getPastLeague().enqueue(object : Callback<EventListResp> {
//            override fun onFailure(call: Call<EventListResp>?, t: Throwable?) {
//                Log.e(tag, t?.message)
//            }
//
//            override fun onResponse(call: Call<EventListResp>?, response: Response<EventListResp>?) {
//                Log.i(tag, "${Gson().toJsonTree(response?.body())}")
//                val nEventList = response?.body()?.listEvent
//                nEventList?.let {
//                    evenList.addAll(it)
//                    adapter.notifyDataSetChanged()
//                }
//            }
//
//        })
//    }

    override fun showEventList(event: List<EventResponse>?) {
        event?.let {
            evenList.addAll(event)
            adapter.notifyDataSetChanged()
        }
    }

}
