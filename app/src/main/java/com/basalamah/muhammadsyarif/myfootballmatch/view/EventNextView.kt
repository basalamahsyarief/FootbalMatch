package com.basalamah.muhammadsyarif.myfootballmatch.view

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse

interface EventNextView {
    fun showEventList(event:List<EventResponse>?)
}