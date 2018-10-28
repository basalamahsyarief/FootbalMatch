package com.basalamah.muhammadsyarif.myfootballmatch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.activities.DetailTeamActivity
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.team_items.view.*
import org.jetbrains.anko.startActivity

class TeamsAdapter(val listTeams:List<TeamResponse>): RecyclerView.Adapter<TeamsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.team_items,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listTeams.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            Picasso.get().load(listTeams[position].strTeamBadge).into(itemView.ivTeams)
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailTeamActivity>("team" to listTeams[position])
            }
        }
    }
}