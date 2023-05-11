package com.app.fringale.Activities.MainDineOutScreenActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.DineoutRestaurantsRecyclerAdapter
import com.app.fringale.databinding.ActivityAccountSettingBinding.inflate
import com.app.fringale.databinding.ActivityMainDineOutScreenBinding

class MainDineOutScreenActivity : AppCompatActivity() {
    private var binding:ActivityMainDineOutScreenBinding?=null
    private var dineoutRestaurantsRecyclerAdapter:DineoutRestaurantsRecyclerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDineOutScreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        dineoutRestaurantsRecyclerAdapter = DineoutRestaurantsRecyclerAdapter(this)
        binding!!.dineoutrestaurantsrecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding!!.dineoutrestaurantsrecyclerview.adapter = dineoutRestaurantsRecyclerAdapter

    }
}