package com.app.fringale.Activities.FavoriteActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.FavouriteRestaurantRecyclerAdapter
import com.app.fringale.R
import com.app.fringale.databinding.ActivityFavoriteBinding
import com.app.fringale.databinding.ActivityProfileBinding

class FavoriteActivity : AppCompatActivity() {
    private var binding:ActivityFavoriteBinding?=null
    private var favouriteRestaurantRecyclerAdapter:FavouriteRestaurantRecyclerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        favouriteRestaurantRecyclerAdapter = FavouriteRestaurantRecyclerAdapter(this)
        binding!!.favouriterecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding!!.favouriterecyclerview.adapter = favouriteRestaurantRecyclerAdapter

    }
}