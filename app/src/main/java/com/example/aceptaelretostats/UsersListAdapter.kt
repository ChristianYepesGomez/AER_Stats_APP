package com.example.aceptaelretostats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.UserModel
import java.util.ArrayList


class UsersListAdapter(private var userList: List<UserModel>) :
    RecyclerView.Adapter<UsersListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_user,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.campoAccepteds.text = currentItem.accepteds
        holder.campoInstitucion.text = currentItem.resolved
        holder.campoNombreUsuario.text = currentItem.nick
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val campoNombreUsuario: TextView = itemView.findViewById(R.id.id_user_name)
        val campoInstitucion: TextView = itemView.findViewById(R.id.id_institution)
        val campoAccepteds: TextView = itemView.findViewById(R.id.id_accepteds)
    }
    
}