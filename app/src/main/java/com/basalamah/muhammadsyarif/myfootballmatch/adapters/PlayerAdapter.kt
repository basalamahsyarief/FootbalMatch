package com.basalamah.muhammadsyarif.myfootballmatch.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.activities.DetailPlayerActivity
import com.basalamah.muhammadsyarif.myfootballmatch.models.PlayerResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.player_items.view.*
import org.jetbrains.anko.startActivity

class PlayerAdapter(private val listPlayers:List<PlayerResponse>): RecyclerView.Adapter<PlayerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_items,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listPlayers.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun bind(position: Int){
            Picasso.get().load(listPlayers.get(position).strCutout).into(itemView.ivPlayer)
            itemView.tvNamaPlayer.text = listPlayers.get(position).strPlayer
            itemView.card.setOnClickListener{
                itemView.context.startActivity<DetailPlayerActivity>("player_detail" to listPlayers[position])
            }
        }
    }
}