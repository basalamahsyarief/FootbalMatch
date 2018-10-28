package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.AdapterView
import android.widget.SearchView
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
        setHasOptionsMenu(true)
        presenter = Presenter(this)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EventAdapter(evenList)
        spinnerNext.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val idLeague:String = when(position){
                    0 -> "4328"
                    1 -> "4331"
                    2 -> "4332"
                    3 -> "4334"
                    4 -> "4337"
                    else -> "4338"
                }
                presenter.getDataEventNext(idLeague)
                setupView()
            }

        }
        svNext.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == null || newText.trim().isEmpty()) {
                    adapter = EventAdapter(evenList)
                    setupView()
                    return false;
                }
                val filteredList = ArrayList<EventResponse>(evenList)
                filteredList.filterNot {
                    it.strAwayTeam?.toLowerCase()!!.contains(newText.toLowerCase())||it.strHomeTeam?.toLowerCase()!!.contains(newText.toLowerCase())
                }.forEach { filteredList.remove(it) }
                adapter = EventAdapter(filteredList)
                setupView()
                return false
            }

        })
    }

    private fun setupView(){
        rvNext.adapter = adapter
        rvNext.layoutManager = LinearLayoutManager(context)
    }
    override fun showEventList(event: List<EventResponse>?) {
        event?.let {
            evenList.clear()
            evenList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}
