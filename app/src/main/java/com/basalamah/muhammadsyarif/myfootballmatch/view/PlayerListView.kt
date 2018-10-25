package com.basalamah.muhammadsyarif.myfootballmatch.view

import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerListResp
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerResponse

interface PlayerListView {
    fun showListPlayer(players:List<PlayerResponse>?)
}