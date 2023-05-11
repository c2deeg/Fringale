package com.app.fringale.Fragments.SearchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.app.fringale.Adapter.SearchGridviewAdapter
import com.app.fringale.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private var binding:FragmentSearchBinding?=null
    private var searchViewAdapter:SearchGridviewAdapter?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view: View = binding!!.root

        listeners()

        searchViewAdapter  = SearchGridviewAdapter(activity as FragmentActivity)
        binding!!.grdiview!!.adapter = searchViewAdapter
//
//        featuredRestaurantsRecyclerViewAdapter = FeaturedRestaurantsRecyclerViewAdapter(activity as FragmentActivity)
//        binding!!.featuredrestaurantsrecyclerview .layoutManager = LinearLayoutManager(activity,
//            LinearLayoutManager.HORIZONTAL,false)
//        binding!!.featuredrestaurantsrecyclerview?.adapter =featuredRestaurantsRecyclerViewAdapter
        return view
    }

    private fun listeners(){

    }


}