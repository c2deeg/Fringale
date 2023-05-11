package com.app.fringale.Fragments.OrdersFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.FeaturedRestaurantsRecyclerViewAdapter
import com.app.fringale.Adapter.UpcomingRecyclerAdapter
import com.app.fringale.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {
    private var binding:FragmentOrdersBinding?=null
    private var upcomingRecyclerAdapter:UpcomingRecyclerAdapter?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val view: View = binding!!.root

        listeners()
        upcomingRecyclerAdapter = UpcomingRecyclerAdapter(activity as FragmentActivity)

        binding!!.upcomingordersrecyclerview .layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL,false)
        binding!!.upcomingordersrecyclerview?.adapter =upcomingRecyclerAdapter

        return view
    }

    private fun listeners(){

    }


}