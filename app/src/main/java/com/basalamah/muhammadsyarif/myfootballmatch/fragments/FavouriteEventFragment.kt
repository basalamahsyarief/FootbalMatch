package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.EventAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.FavouriteMatchPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import kotlinx.android.synthetic.main.fragment_favourite_event.*


class FavouriteEventFragment : Fragment(), EventNextView {


    private val eventList = mutableListOf<EventResponse>()
    private lateinit var adapter: EventAdapter
    private lateinit var presenter: FavouriteMatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = FavouriteMatchPresenter(this)
        adapter = EventAdapter(eventList)
        presenter.getFavouriteEvent(context)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFav.adapter = adapter
        rvFav.layoutManager = LinearLayoutManager(context)

    }
    override fun onResume() {
        super.onResume()
        presenter.getFavouriteEvent(context)
    }
    override fun showEventList(event: List<EventResponse>?) {
        eventList.clear()
        event?.let { eventList.addAll(it) }
        adapter.notifyDataSetChanged()
    }
}
