package com.basalamah.muhammadsyarif.myfootballmatch.view

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamBadges

interface DetailView {
    fun showDetail(detail: EventResponse?)
    fun showBadgeHome(teamHomeResponse: TeamBadges?)
    fun showBadgeAway(teamAwayResponse: TeamBadges?)
}