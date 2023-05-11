package com.app.fringale.Activities.ViewCartActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.CartRecyclerAdapter
import com.app.fringale.databinding.ActivityViewCartBinding

class ViewCartActivity : AppCompatActivity() {
    private var binding:ActivityViewCartBinding?=null
    private var cartRecyclerAdapter:CartRecyclerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCartBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()
        cartRecyclerAdapter = CartRecyclerAdapter(this)
        binding!!.cartrecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding!!.cartrecyclerview.adapter = cartRecyclerAdapter


    }

    private fun listeners() {

    }
}