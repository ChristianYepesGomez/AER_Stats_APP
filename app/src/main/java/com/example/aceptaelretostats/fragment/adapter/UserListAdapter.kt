package com.example.aceptaelretostats.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aceptaelretostats.R
import com.example.aceptaelretostats.model.StatsModel
import com.example.aceptaelretostats.model.Users
import java.util.*
import kotlin.collections.ArrayList


class UserListAdapter(private var userList: MutableList<Users>) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>(), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        userList.sortByDescending { it.accepteds.toInt() }
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

    override fun getFilter(): Filter {
        var userFilterList: MutableList<Users>
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    userFilterList = userList
                } else {
                    val resultList = mutableListOf<Users>()
                    for (row in userList) {
                        if (row.nick.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    userFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                userFilterList = results?.values as MutableList<Users>
                notifyDataSetChanged()
            }

        }
    }

}