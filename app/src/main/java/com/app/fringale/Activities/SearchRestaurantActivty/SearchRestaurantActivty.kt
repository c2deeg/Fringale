package com.app.fringale.Activities.SearchRestaurantActivty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.SearchGridviewAdapter
import com.app.fringale.Adapter.ViewSearchRecyclerAdapter
import com.app.fringale.R
import com.app.fringale.databinding.ActivitySearchRestaurantActivtyBinding
import com.app.fringale.databinding.ActivityViewRestaurantsDetailBinding

class SearchRestaurantActivty : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivitySearchRestaurantActivtyBinding?=null
    private var searchRecyclerAdapter:ViewSearchRecyclerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchRestaurantActivtyBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()

        searchRecyclerAdapter = ViewSearchRecyclerAdapter(this)

        binding?.searchrecyclerview?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.searchrecyclerview?.adapter = searchRecyclerAdapter

    }

    private fun listeners(){
        binding!!.imgcross.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {

    }
}