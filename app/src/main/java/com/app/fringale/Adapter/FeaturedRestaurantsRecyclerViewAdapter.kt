package com.app.fringale.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils

class FeaturedRestaurantsRecyclerViewAdapter(private val activity: FragmentActivity) : RecyclerView.Adapter<FeaturedRestaurantsRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeaturedRestaurantsRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.featuredrecycleritem, parent, false)
        return FeaturedRestaurantsRecyclerViewAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var linear = itemView.findViewById<LinearLayout>(R.id.lin_restaurant)
//        var tv_nameconstructionwork = itemView.findViewById<TextView>(R.id.tv_nameconstructionwork)
//        var tv_pricedetail = itemView.findViewById<TextView>(R.id.tv_pricedetail)
//        var tv_country = itemView.findViewById<TextView>(R.id.tv_country)
//        var tv_jobcity = itemView.findViewById<TextView>(R.id.tv_jobcity)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.linear.setOnClickListener{
            Utils.movetoActivity(activity,ViewRestaurantsDetailActivity())
        }


    }
}