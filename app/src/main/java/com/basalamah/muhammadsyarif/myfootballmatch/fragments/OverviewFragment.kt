package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.TeamPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.TeamView
import kotlinx.android.synthetic.main.fragment_overview.*

class OverviewFragment : Fragment(),TeamView {

    lateinit var presenter:TeamPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = TeamPresenter(this)
        val team:TeamResponse? = arguments?.getParcelable("team_detail")
        presenter.getTeam(team?.idTeam)
    }

    override fun showTeam(team: List<TeamResponse>) {
        tvOverview.text = team[0].strDescriptionEN
    }
}
