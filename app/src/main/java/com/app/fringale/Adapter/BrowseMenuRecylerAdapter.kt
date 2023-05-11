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

class BrowseMenuRecylerAdapter(private val activity: FragmentActivity) : RecyclerView.Adapter<BrowseMenuRecylerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrowseMenuRecylerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.browsemenurecyleritem, parent, false)
        return BrowseMenuRecylerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return 100
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var linearlay = itemView.findViewById<LinearLayout>(R.id.linearlay)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.linearlay.setOnClickListener{
            Toast.makeText(activity, position.toString(), Toast.LENGTH_SHORT).show()
        }


    }
}