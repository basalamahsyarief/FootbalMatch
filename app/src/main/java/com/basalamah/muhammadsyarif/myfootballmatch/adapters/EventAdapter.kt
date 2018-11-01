package com.basalamah.muhammadsyarif.myfootballmatch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.activities.DetailActivity
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.Utils
import kotlinx.android.synthetic.main.list_events.view.*
import okhttp3.internal.Util
import org.jetbrains.anko.intentFor

class EventAdapter(val listEvent:List<EventResponse>): RecyclerView.Adapter<EventAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.list_events,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            val events: EventResponse = listEvent[position]
            itemView?.tvAway?.text = events.strAwayTeam
            itemView?.tvHome?.text = events.strHomeTeam
            itemView?.tvScoreHome?.text = events.intHomeScore
            itemView?.scoreAway?.text = events.intAwayScore
            itemView?.tvTanggal?.text = events.strDate?.let { events.strTime?.let { it1 -> Utils().GMT(it, it1) } }
            itemView?.linLay?.setOnClickListener {
                itemView.context.startActivity(
                        itemView.context.intentFor<DetailActivity>(
                                "idEvent" to events.idEvent,
                                "awayTeam" to events.strAwayTeam,
                                "homeTeam" to events.strHomeTeam,
                                "awayScore" to events.intAwayScore,
                                "homeScore" to events.intHomeScore,
                                "dateEvent" to events.strDate,
                                "strTime" to events.strTime

                        )
                )
            }
        }
    }
}