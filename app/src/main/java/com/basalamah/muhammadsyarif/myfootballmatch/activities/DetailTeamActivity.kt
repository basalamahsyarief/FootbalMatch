package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.AllViewPagerAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.OverviewFragment
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.PlayersFragment
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    lateinit var adapter:AllViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        setSupportActionBar(toolbar)
        val team:TeamResponse = intent.getParcelableExtra("team")
        adapter = AllViewPagerAdapter(supportFragmentManager)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        putParcel(team)
        main_content.adapter = adapter
        tabs.setupWithViewPager(main_content)
    }
    private fun putParcel(team: TeamResponse){
        val bundle = Bundle()
        bundle.putParcelable("team_detail", team)
        tvNamaTeam.text = team.strTeam
        tvTahun.text = team.intFormedYear
        tvStadium.text = team.strStadium
        Picasso.get().load(team.strTeamBadge).into(ivLogo)
        val players = PlayersFragment()
        val overview = OverviewFragment()
        players.arguments= bundle
        overview.arguments = bundle
        adapter.addFragment(overview,"Description")
        adapter.addFragment(players,"Players")

    }
}
