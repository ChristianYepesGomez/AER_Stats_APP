package com.example.aceptaelretostats.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aceptaelretostats.R
import com.example.aceptaelretostats.model.Users
import java.util.*


class UserListAdapter(private var userList: MutableList<Users>) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        userList.sortByDescending { it.resolved.toInt() }
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_user,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.campoAccepteds.text =
            currentItem.resolved.plus("/".plus(currentItem.intents.plus(" AC")))
        holder.campoID.text = "ID:".plus(currentItem.id)
        holder.campoNombreUsuario.text = currentItem.nick
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val campoNombreUsuario: TextView = itemView.findViewById(R.id.id_user_name)
        val campoID: TextView = itemView.findViewById(R.id.id_accepteds_totales)
        val campoAccepteds: TextView = itemView.findViewById(R.id.id_accepteds)
    }


}