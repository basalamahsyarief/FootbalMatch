package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.Presenter
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.EventAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import kotlinx.android.synthetic.main.fragment_next.*


class NextFragment : Fragment(), EventNextView {

    private val evenList = mutableListOf<EventResponse>()
    private lateinit var adapter: EventAdapter
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = Presenter(this)
        presenter.getDataEventNext()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EventAdapter(evenList)
        rvNext.adapter = adapter
        rvNext.layoutManager = LinearLayoutManager(context)
    }

    override fun showEventList(event: List<EventResponse>?) {
        event?.let { evenList.addAll(it) }
        adapter.notifyDataSetChanged()
    }
}
