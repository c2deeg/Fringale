package com.app.fringale.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Models.Item
import com.app.fringale.R
import com.bumptech.glide.Glide

class ExploreRestaurantsRecyclerAdapter(private val activity: FragmentActivity, private val items: List<Item>) : RecyclerView.Adapter<ExploreRestaurantsRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExploreRestaurantsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.explorerestaurantsrecycleritem, parent, false)
        return ExploreRestaurantsRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var tvrestaurantname = itemView.findViewById<TextView>(R.id.tvrestaurantname)
        var tvrating = itemView.findViewById<TextView>(R.id.tvrating)
        var tvrestauranttype = itemView.findViewById<TextView>(R.id.tvrestauranttype)
        var tvlocation = itemView.findViewById<TextView>(R.id.tvlocation)
        var linmain = itemView.findViewById<LinearLayout>(R.id.linmain)
        var imgrestaurant = itemView.findViewById<ImageView>(R.id.imgrestaurant)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvrestaurantname.text= items.get(position).name
        holder.tvrating.text= items.get(position).rating.toString()
        holder.tvlocation.text= items.get(position).city
        Glide.with(activity)
            .load(items.get(position).avatar).placeholder(R.drawable.cadhipannier_img)
            .into(holder.imgrestaurant!!)

        holder.linmain.setOnClickListener{
            var intent = Intent(activity, ViewRestaurantsDetailActivity::class.java)
            intent.putExtra("restaurantid",items.get(position)._id)
            activity.startActivity(intent)
        }

    }
}