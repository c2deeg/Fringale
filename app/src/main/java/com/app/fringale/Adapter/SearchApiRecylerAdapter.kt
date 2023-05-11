package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Models.SearchRestaurant.Data
import com.app.fringale.R

class SearchApiRecylerAdapter(private val activity: FragmentActivity,private val data: List<Data>) : RecyclerView.Adapter<SearchApiRecylerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchApiRecylerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.searchrestaurantrecyleritem, parent, false)
        return SearchApiRecylerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var tvsearchedres = itemView.findViewById<TextView>(R.id.tvsearchedres)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvsearchedres.text =data.get(position).name



    }
}