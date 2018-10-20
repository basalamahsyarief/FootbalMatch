package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.AllViewPagerAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.OverviewFragment
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.PlayersFragment
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.content_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    lateinit var team:TeamResponse
    lateinit var adapter:AllViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        setSupportActionBar(toolbar)
        supportActionBar?.title = team.strTeam
        team = intent.getParcelableExtra("team")
        val bundle = Bundle()
        bundle.putParcelable("team_detail", team)
        val players = PlayersFragment()
        val overview = OverviewFragment()
        players.arguments = bundle
        overview.arguments = bundle
        adapter.addFragment(PlayersFragment(),"Players")
        adapter.addFragment(OverviewFragment(),"Description")
        main_content.adapter = adapter
        tabs.setupWithViewPager(main_content)
    }
}
