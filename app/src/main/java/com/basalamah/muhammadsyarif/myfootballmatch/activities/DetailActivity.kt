package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.basalamah.muhammadsyarif.myfootballmatch.*
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamBadges
import com.basalamah.muhammadsyarif.myfootballmatch.presenters.DetailPresenter
import com.basalamah.muhammadsyarif.myfootballmatch.view.DetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), DetailView {

    private var isExisted = false
    private var response: EventResponse? = null
    var menu: Menu? = null
    private lateinit var presenter: DetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter = DetailPresenter(this)
        presenter.getDetail(intent.getStringExtra("idEvent"))
        presenter.getDataImage(intent.getStringExtra("homeTeam"),"home")
        presenter.getDataImage(intent.getStringExtra("awayTeam"),"away")
        isDataExist()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav,menu)
        this.menu=menu
        if (isExisted) {
            this.menu?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp)
        } else {
           this.menu?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
        }
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.ic_fav -> {
                if (isExisted) {
                    RemoveMatchDB(this, response)
                } else {
                    addMatchDB(response)
                }
                isExisted = !isExisted
                setFavorite()
                true
            }
            else -> {return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setFavorite(){
        if (isExisted) {
            menu?.getItem(0)?.icon = ContextCompat.getDrawable(applicationContext, R.drawable.ic_favorite_black_24dp)
        } else {
            menu?.getItem(0)?.icon = ContextCompat.getDrawable(applicationContext, R.drawable.ic_favorite_border_black_24dp)
        }
    }

    override fun showDetail(detail: EventResponse?) {
        tvHome.text = intent.getStringExtra("homeTeam")
        tvAway.text = intent.getStringExtra("awayTeam")
        tvHomeYellow.text = detail?.strHomeYellowCards
        tvAwayYellow.text = detail?.strAwayYellowCards
        tvHomeRed.text = detail?.strHomeRedCards
        tvAwayRed.text = detail?.strAwayRedCards
        tvTanggal.text = intent.getStringExtra("dateEvent")
        scoreHome.text = intent.getStringExtra("homeScore")
        scoreAway.text = intent.getStringExtra("awayScore")
        response = detail
        Toast.makeText(this,response.toString(),Toast.LENGTH_LONG).show()
    }
    override fun showBadgeHome(teamHomeResponse: TeamBadges?) {

        Picasso.get().load(teamHomeResponse?.listTeams?.get(0)?.badge).into(ivHome)
    }

    private fun addMatchDB(event: EventResponse?){
        try {
            database.use {
                insert(EventResponse.TABLE,
                        EventResponse.EVENT_ID to event?.idEvent,
                        EventResponse.EVENT_DATE to event?.dateEvent,
                        EventResponse.HOME_TEAM to event?.strHomeTeam,
                        EventResponse.AWAY_TEAM to event?.strAwayTeam,
                        EventResponse.SCORE_HOME to event?.intHomeScore,
                        EventResponse.SCORE_AWAY to event?.intAwayScore,
                        EventResponse.HOME_YELLOW to event?.strHomeYellowCards,
                        EventResponse.AWAY_YELLOW to event?.strAwayYellowCards,
                        EventResponse.HOME_RED to event?.strHomeRedCards,
                        EventResponse.AWAY_RED to event?.strAwayRedCards)
            }
        }catch (e: SQLiteConstraintException){
            toast("${e.message}").show()
        }
    }
    private fun RemoveMatchDB(context: Context, event: EventResponse?){
        try{
            context.database.use{
                delete(EventResponse.TABLE,
                        EventResponse.EVENT_ID +" = {id}","id" to intent.getStringExtra("idEvent"))
            }
        }catch (e: SQLiteConstraintException){
            context.toast("${e.message}")
        }
    }
    private fun isDataExist(){
        database.use {
            val fav = select(EventResponse.TABLE).whereArgs(EventResponse.EVENT_ID + " = {id}","id" to intent.getStringExtra("idEvent"))
                   .parseList(classParser<EventResponse>())
            if (!fav.isEmpty()) isExisted = true
        }
    }
    override fun showBadgeAway(teamAwayResponse: TeamBadges?) {
        Picasso.get().load(teamAwayResponse?.listTeams?.get(0)?.badge).into(ivAway)
    }
}
