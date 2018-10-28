package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_player.*
import kotlinx.android.synthetic.main.content_detail_player.*

class DetailPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)
        setSupportActionBar(toolbar)
        val player:PlayerResponse = intent.getParcelableExtra("player_detail")
        supportActionBar?.title = player.strPlayer
        if (!player.strFanart1.equals(null)){
            Picasso.get().load(player.strFanart1).into(ivFan)
        }else{
            Picasso.get().load(player.strThumb).into(ivFan)
        }
        tvDesc.text = player.strDescriptionEN
        tvWeight.text=player.strWeight
        tvHeight.text=player.strHeight
    }
}
