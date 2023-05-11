package com.app.fringale.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Models.Item
import com.app.fringale.R

class AllRestaurantsRecyclerAdapter(private val activity: FragmentActivity,private val items: List<Item>) : RecyclerView.Adapter<AllRestaurantsRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllRestaurantsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.allrestaurantsrecycleritem, parent, false)
        return AllRestaurantsRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var tvrestaurantname = itemView.findViewById<TextView>(R.id.tvrestaurantname)
        var linear = itemView.findViewById<LinearLayout>(R.id.linear)
//        var tv_nameconstructionwork = itemView.findViewById<TextView>(R.id.tv_nameconstructionwork)
//        var tv_pricedetail = itemView.findViewById<TextView>(R.id.tv_pricedetail)
//        var tv_country = itemView.findViewById<TextView>(R.id.tv_country)
//        var tv_jobcity = itemView.findViewById<TextView>(R.id.tv_jobcity)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvrestaurantname.text = items.get(position).name

        holder.linear.setOnClickListener{
            var intent  = Intent(activity, ViewRestaurantsDetailActivity::class.java)
            intent.putExtra("id",items.get(position)._id)
            activity.startActivity(intent)
        }

    }
}
