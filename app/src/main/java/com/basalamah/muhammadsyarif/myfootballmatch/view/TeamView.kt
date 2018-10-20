package com.basalamah.muhammadsyarif.myfootballmatch.view

import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse

interface TeamView {
    fun showTeam(team:List<TeamResponse>)
}