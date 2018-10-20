package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        presenter.getTeamList("4328")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TeamsAdapter(teamList)
        rvTeams.adapter = adapter
        rvTeams.layoutManager = GridLayoutManager(context,2)
    }

    override fun showTeam(team: List<TeamResponse>) {
        team.let {
            teamList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}
