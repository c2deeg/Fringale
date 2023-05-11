package com.app.fringale.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Models.GetCategoryByName.Data
import com.app.fringale.R
import com.bumptech.glide.Glide

class FoodScreenFoodCategoriesRecyclerAdapter(private val activity: FragmentActivity,private val data: List<Data>) : RecyclerView.Adapter<FoodScreenFoodCategoriesRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodScreenFoodCategoriesRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.foodscreenfoodcategoriesrecycleritem, parent, false)
        return FoodScreenFoodCategoriesRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var imgcategory = itemView.findViewById<ImageView>(R.id.imgcategory)
        var tvcategoryname = itemView.findViewById<TextView>(R.id.tvcategoryname)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvcategoryname.text =data.get(position).categoryName
        Glide.with(activity)
            .load(data.get(position).categoryImage).placeholder(R.drawable.momos)
            .into(holder.imgcategory!!)
    }
}