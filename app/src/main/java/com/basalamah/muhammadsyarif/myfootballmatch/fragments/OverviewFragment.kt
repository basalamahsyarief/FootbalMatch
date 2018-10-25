package com.basalamah.muhammadsyarif.myfootballmatch.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import kotlinx.android.synthetic.main.fragment_overview.*

class OverviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val team:TeamResponse? = arguments?.getParcelable("team_detail")
        tvOverview.text =team?.strDescriptionEN
    }

}
