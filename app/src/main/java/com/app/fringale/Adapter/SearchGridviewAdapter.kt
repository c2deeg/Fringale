package com.app.fringale.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.app.fringale.R

class SearchGridviewAdapter(private val activity: FragmentActivity) :
    BaseAdapter() {
    // in base adapter class we are creating variables
    // for layout inflater, course image view and course text view.
    private var layoutInflater: LayoutInflater? = null
    private lateinit var tv_shopname: TextView
    private lateinit var shopimg: ImageView

    // below method is use to return the count of course list
    override fun getCount(): Int {
        return 20
    }

    // below function is use to return the item of grid view.
    override fun getItem(position: Int): Any? {
        return null
    }

    // below function is use to return item id of grid view.
    override fun getItemId(position: Int): Long {
        return 0
    }

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        if (layoutInflater == null) {
            layoutInflater =
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        // on the below line we are checking if convert view is null.
        // If it is null we are initializing it.
        if (convertView == null) {
            // on below line we are passing the layout file
            // which we have to inflate for each item of grid view.
            convertView = layoutInflater!!.inflate(R.layout.listoffooditem, null)
        }

//        courseIV = convertView!!.findViewById(R.id.idIVCourse)

//        shopimg = convertView!!.findViewById(R.id.shopimg)
//
//        tv_shopname = convertView!!.findViewById(R.id.tv_shopname)


//
//
//        courseTV.setText(courseList.get(position).courseName)
        return convertView
    }
}