package com.example.aceptaelretostats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aceptaelretostats.model.Institutions


class InstitutionsListAdapter(private var institutions: List<Institutions>) :
    RecyclerView.Adapter<InstitutionsListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_institutions,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = institutions[position]
        println(currentItem)
        holder.campoNombreInstitucion.text = currentItem.institution
    }

    override fun getItemCount(): Int {
        return institutions.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val campoNombreInstitucion: TextView = itemView.findViewById(R.id.id_institution)

    }

}