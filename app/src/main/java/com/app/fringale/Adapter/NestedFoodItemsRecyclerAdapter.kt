package com.app.fringale.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Models.GetRestaurantsItems.Item
import com.app.fringale.R
import com.app.fringale.StaticModels.MM
import com.app.fringale.interfaces.NestedClickListener
import com.bumptech.glide.Glide
import java.lang.String
import kotlin.Int

class NestedFoodItemsRecyclerAdapter(
    private val activity: FragmentActivity,
    private val listener: NestedClickListener,
   private val items: List<Item>
) : RecyclerView.Adapter<NestedFoodItemsRecyclerAdapter.ViewHolder>() {
    var arrayList:ArrayList<MM> = ArrayList()
    var arrayList2:ArrayList<kotlin.String> = ArrayList()



    var value = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NestedFoodItemsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nestedrecycleradapteritem, parent, false)
        return NestedFoodItemsRecyclerAdapter.ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var linear = itemView.findViewById<LinearLayout>(R.id.lin_restaurant)
        var imgadd = itemView.findViewById<ImageView>(R.id.imgadd)
        var tvcount = itemView.findViewById<TextView>(R.id.tvcount)
        var tvitemname = itemView.findViewById<TextView>(R.id.tvitemname)
        var tvitemprice = itemView.findViewById<TextView>(R.id.tvitemprice)
        var imggsub = itemView.findViewById<ImageView>(R.id.imggsub)
        var imgitems = itemView.findViewById<ImageView>(R.id.imgitems)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvitemname.text = items.get(position).itemName
        holder.tvitemprice.text = "$"+items.get(position).price.toString()
        Glide.with(activity)
            .load(items.get(position).avatar).placeholder(R.drawable.cadhipannier_img)
            .into(holder.imgitems!!)

        arrayList.add(MM(0))
        Log.d("checkingforsize",arrayList.size.toString())

        holder.imgadd.setOnClickListener {
            var qnt: Int = arrayList.get(position).count
            qnt++
            value++
            arrayList.get(position).count = qnt
            listener.passData(arrayList,qnt,value)
            holder.tvcount.setText(String.valueOf(arrayList.get(position).count))
            holder.imggsub.visibility =View.VISIBLE
        }

        holder.imggsub.setOnClickListener{
            var qnt: Int = arrayList.get(position).count
            if (qnt>0){
                qnt--
                value--
                arrayList.get(position).count = qnt
                listener.passData(arrayList,qnt,value)
                holder.tvcount.setText(String.valueOf(arrayList.get(position).count))
            }

        }




    }
}