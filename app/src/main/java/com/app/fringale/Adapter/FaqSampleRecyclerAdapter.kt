package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.R

class FaqSampleRecyclerAdapter (fragmentActivity: FragmentActivity) : RecyclerView.Adapter<FaqSampleRecyclerAdapter.ViewHolder>() {
var value:Boolean = true

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FaqSampleRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.faqsamplerecycleritem, parent, false)
        return FaqSampleRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var imggadd = itemView.findViewById<ImageView>(R.id.imggadd)
        var tvdescription = itemView.findViewById<TextView>(R.id.tvdescription)
//        var tv_pricedetail = itemView.findViewById<TextView>(R.id.tv_pricedetail)
//        var tv_country = itemView.findViewById<TextView>(R.id.tv_country)
//        var tv_jobcity = itemView.findViewById<TextView>(R.id.tv_jobcity)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imggadd.setOnClickListener{
            if (value){
                holder.tvdescription.visibility = View.VISIBLE
                holder.imggadd.setImageResource(R.drawable.ic_baseline_minimize_24)
            }else{
                holder.tvdescription.visibility = View.GONE
                holder.imggadd.setImageResource(R.drawable.ic_baseline_add_24)

            }
            value = !value
        }

    }

}