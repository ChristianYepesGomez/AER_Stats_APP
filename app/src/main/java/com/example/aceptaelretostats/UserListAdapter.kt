package com.example.aceptaelretostats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aceptaelretostats.model.StatsModel


class StatsListAdapter(private var statsList: StatsModel) :
    RecyclerView.Adapter<StatsListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_user,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = statsList.users[position]

        holder.campoAccepteds.text = currentItem.accepteds
        holder.campoInstitucion.text = currentItem.resolved
        holder.campoNombreUsuario.text = currentItem.nick
    }

    override fun getItemCount(): Int {
        return statsList.users.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val campoNombreUsuario: TextView = itemView.findViewById(R.id.id_user_name)
        val campoInstitucion: TextView = itemView.findViewById(R.id.id_institution)
        val campoAccepteds: TextView = itemView.findViewById(R.id.id_accepteds)
    }

}