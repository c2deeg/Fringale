package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewCartActivity.ViewCartActivity
import com.app.fringale.R

class CartRecyclerAdapter(private val activity: ViewCartActivity) :  RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cartordersrecycleritems, parent, false)
        return CartRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        var imgdecrease = itemView.findViewById<ImageView>(R.id.imgdecrease)
//        var imgincrease = itemView.findViewById<ImageView>(R.id.imgincrease )


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {




    }
}