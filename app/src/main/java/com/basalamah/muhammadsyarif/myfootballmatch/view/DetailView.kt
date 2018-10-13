package com.basalamah.muhammadsyarif.myfootballmatch.view

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse

interface DetailView {
    fun showDetail(detail: EventResponse?)
    fun showBadgeHome(teamHomeResponse: TeamResponse?)
    fun showBadgeAway(teamAwayResponse: TeamResponse?)
}