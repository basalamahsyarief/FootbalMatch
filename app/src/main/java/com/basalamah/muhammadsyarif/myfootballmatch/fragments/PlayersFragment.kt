package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.PlayerAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerResponse
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.PlayersListPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.PlayerListView
import kotlinx.android.synthetic.main.fragment_players.*

class PlayersFragment : Fragment(),PlayerListView {

    lateinit var adapter:PlayerAdapter
    lateinit var presenter:PlayersListPresenter
    val listPlayer = mutableListOf<PlayerResponse>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = PlayerAdapter(listPlayer)
        presenter = PlayersListPresenter(this)
        val team: TeamResponse? = arguments?.getParcelable("team_detail")
        presenter.getDataListPlayer(team?.idTeam)
        rvPlayers.layoutManager = GridLayoutManager(activity,2)
        rvPlayers.adapter = adapter
    }

    override fun showListPlayer(players: List<PlayerResponse>?) {
        players?.let {
            listPlayer.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }



}
