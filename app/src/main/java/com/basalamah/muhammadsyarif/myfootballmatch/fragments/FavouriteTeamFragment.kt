package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.TeamsAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.database
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import kotlinx.android.synthetic.main.fragment_favourite_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavouriteTeamFragment : Fragment(){
    lateinit var adapter:TeamsAdapter
    private val teamList = mutableListOf<TeamResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TeamsAdapter(teamList)
        getFavouriteTeam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFavTeams.layoutManager = GridLayoutManager(context,2)
        rvFavTeams.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        getFavouriteTeam()
    }

    private fun getFavouriteTeam(){
        context?.database?.use {
            val fav = select(TeamResponse.TABLE)
                    .parseList(classParser<TeamResponse>())
            teamList.clear()
            fav.let { teamList.addAll(it) }
            adapter.notifyDataSetChanged()
        }
    }

}
