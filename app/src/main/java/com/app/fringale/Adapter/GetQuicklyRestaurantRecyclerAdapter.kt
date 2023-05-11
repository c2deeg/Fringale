package com.app.fringale.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Models.GetRestaurantFrequently.Message
import com.app.fringale.R
import com.app.fringale.Utils.Utils

class GetQuicklyRestaurantRecyclerAdapter(
    private val activity: FragmentActivity,
    private val message: List<Message>
) : RecyclerView.Adapter<GetQuicklyRestaurantRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GetQuicklyRestaurantRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.getquicklyrecycleritem, parent, false)
        return GetQuicklyRestaurantRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return message.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var linlaymain = itemView.findViewById<LinearLayout>(R.id.linlaymain)
        var tvrestaurantname = itemView.findViewById<TextView>(R.id.tvrestaurantname)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvrestaurantname.text = message.get(position).name
        holder.linlaymain.setOnClickListener{
            var intent = Intent(activity,ViewRestaurantsDetailActivity::class.java)
            intent.putExtra("restaurantid",message.get(position)._id)
            activity.startActivity(intent)

        }

    }
}