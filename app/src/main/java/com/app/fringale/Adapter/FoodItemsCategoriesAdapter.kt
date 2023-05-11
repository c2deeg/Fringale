package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Models.GetRestaurantsItems.Data
import com.app.fringale.R
import com.app.fringale.interfaces.NestedClickListener

class FoodItemsCategoriesAdapter(
    private val activity: FragmentActivity,
    private val listener: NestedClickListener,
    private val  data: List<Data>,


    ) : RecyclerView.Adapter<FoodItemsCategoriesAdapter.ViewHolder>() {


    var isExpandable: Boolean = false
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodItemsCategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fooditemcategories, parent, false)
        return FoodItemsCategoriesAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var linearopen = itemView.findViewById<LinearLayout>(R.id.linearopen)
        var nestedrecyclerview = itemView.findViewById<RecyclerView>(R.id.nestedrecyclerview)
        var tvcategoryname = itemView.findViewById<TextView>(R.id.tvcategoryname)
        var imgdropdown = itemView.findViewById<ImageView>(R.id.imgdropdown)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvcategoryname.text = data.get(position)._id
        holder.linearopen.setOnClickListener{

            if (isExpandable) {
                holder.nestedrecyclerview.visibility = View.VISIBLE
                holder.imgdropdown.setImageResource(R.drawable.uparrow)

            } else {
                holder.imgdropdown.setImageResource(R.drawable.caretdownss)

                holder.nestedrecyclerview.visibility = View.GONE

//                notifyItemChanged(holder.adapterPosition)





            }
            isExpandable = !isExpandable



        }


        var nestedFoodItemsRecyclerAdapter:NestedFoodItemsRecyclerAdapter?=null
        nestedFoodItemsRecyclerAdapter   = NestedFoodItemsRecyclerAdapter(activity,listener,data.get(position).items)


     holder.nestedrecyclerview .layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL,false)
        holder!!.nestedrecyclerview?.adapter =nestedFoodItemsRecyclerAdapter



//        holder.nestedrecyclerview.setVisibility(if (isExpandable) View.VISIBLE else View.GONE)

    }
}