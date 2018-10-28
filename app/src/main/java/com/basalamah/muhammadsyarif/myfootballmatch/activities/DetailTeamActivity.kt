package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.AllViewPagerAdapter
import com.basalamah.muhammadsyarif.myfootballmatch.database
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.OverviewFragment
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.PlayersFragment
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.TeamPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.TeamView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast

class DetailTeamActivity : AppCompatActivity(),TeamView {

    private var isExisted = false
    var menu: Menu? = null
    lateinit var team:TeamResponse
    lateinit var adapter:AllViewPagerAdapter
    lateinit var presenter:TeamPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        team = intent.getParcelableExtra("team")
        presenter = TeamPresenter(this)
        adapter = AllViewPagerAdapter(supportFragmentManager)
        putParcel(team)
        isDataExist(team)
        main_content.adapter = adapter
        presenter.getTeam(team.idTeam)
        tabs.setupWithViewPager(main_content)
    }
    private fun putParcel(team: TeamResponse){
        val bundle = Bundle()
        bundle.putParcelable("team_detail", team)
        tvNamaTeam.text = team.strTeam
        tvTahun.text = team.intFormedYear
        Picasso.get().load(team.strTeamBadge).into(ivLogo)
        val players = PlayersFragment()
        val overview = OverviewFragment()
        players.arguments= bundle
        overview.arguments = bundle
        adapter.addFragment(overview,"Description")
        adapter.addFragment(players,"Players")

    }
    private fun isDataExist(team: TeamResponse){
        database.use {
            val fav = select(TeamResponse.TABLE).whereArgs(TeamResponse.ID_TEAM + " = {id}","id" to team.idTeam)
                    .parseList(classParser<TeamResponse>())
            if (!fav.isEmpty()) isExisted = true
        }
    }
    private fun setFavorite(){
        if (isExisted) {
            menu?.getItem(0)?.icon = ContextCompat.getDrawable(applicationContext, R.drawable.ic_favorite_black_24dp)
        } else {
            menu?.getItem(0)?.icon = ContextCompat.getDrawable(applicationContext, R.drawable.ic_favorite_border_black_24dp)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav,menu)
        this.menu=menu
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.ic_fav -> {
                if (isExisted) {
                    RemoveTeamDB(this, team)
                } else {
                    addTeamDB(team)
                }
                isExisted = !isExisted
                setFavorite()
                true
            }
            else -> {return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun addTeamDB(team: TeamResponse?){
        try {
            database.use {
                insert(TeamResponse.TABLE,
                        TeamResponse.ID_TEAM to team?.idTeam,
                        TeamResponse.INT_FORMED_YEAR to team?.intFormedYear,
                        TeamResponse.STR_COUNTRY to team?.strCountry,
                        TeamResponse.STR_DESC_EN to "",
                        TeamResponse.STR_STADIUM to "",
                        TeamResponse.STR_TEAM to team?.strTeam,
                        TeamResponse.STR_TEAM_BADGE to team?.strTeamBadge,
                        TeamResponse.STR_TEAM_BANNER to team?.strTeamBanner,
                        TeamResponse.STR_TEAM_LOGO to team?.strTeamLogo)
            }
        }catch (e: SQLiteConstraintException){
            toast("${e.message}").show()
        }
    }
    private fun RemoveTeamDB(context: Context, event:TeamResponse){
        try{
            context.database.use{
                delete(TeamResponse.TABLE,
                        TeamResponse.ID_TEAM +" = {id}","id" to event.idTeam)
            }
        }catch (e: SQLiteConstraintException){
            context.toast("${e.message}")
        }
    }
    override fun showTeam(team: List<TeamResponse>) {
        tvStadium.text = team[0].strStadium
    }
}
