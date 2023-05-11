package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.R

class FilterRecyclerAdapter (fragmentActivity: FragmentActivity) : RecyclerView.Adapter<FilterRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilterRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.foodcategoriesrecyleritem, parent, false)
        return FilterRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        var linear = itemView.findViewById<LinearLayout>(R.id.linear)
//        var tv_nameconstructionwork = itemView.findViewById<TextView>(R.id.tv_nameconstructionwork)
//        var tv_pricedetail = itemView.findViewById<TextView>(R.id.tv_pricedetail)
//        var tv_country = itemView.findViewById<TextView>(R.id.tv_country)
//        var tv_jobcity = itemView.findViewById<TextView>(R.id.tv_jobcity)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}