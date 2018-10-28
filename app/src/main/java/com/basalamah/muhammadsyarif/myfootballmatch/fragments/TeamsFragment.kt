package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SearchView

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.TeamsAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.TeamPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.TeamView
import kotlinx.android.synthetic.main.fragment_teams.*

class TeamsFragment : Fragment(),TeamView {

    private lateinit var adapter:TeamsAdapter
    private lateinit var presenter:TeamPresenter
    private val teamList = mutableListOf<TeamResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = TeamPresenter(this)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TeamsAdapter(teamList)
        spTeam.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
                presenter.getTeamList(idLeague)
                setupView()
            }

        }
        svTeams.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == null || newText.trim().isEmpty()) {
                    adapter = TeamsAdapter(teamList)
                    setupView()
                    return false;
                }
                val filteredList = ArrayList<TeamResponse>(teamList)
                filteredList.filterNot {
                    it.strTeam?.toLowerCase()!!.contains(newText.toLowerCase())
                }.forEach { filteredList.remove(it) }
                adapter = TeamsAdapter(filteredList)
                setupView()
                return false
            }

        })
    }

    private fun setupView(){
        rvTeams.adapter = adapter
        rvTeams.layoutManager = GridLayoutManager(context,2)
    }

    override fun showTeam(team: List<TeamResponse>) {
        team.let {
            teamList.clear()
            teamList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}
