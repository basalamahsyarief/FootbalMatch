package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import android.content.Context
import com.basalamah.muhammadsyarif.myfootballmatch.database
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavouritePresenter(private val view:EventNextView) {
    fun getFavouriteList(context: Context?){
        context?.database?.use {
            val fav = select(EventResponse.TABLE)
                    .parseList(classParser<EventResponse>())
            view.showEventList(fav)
        }
    }
}