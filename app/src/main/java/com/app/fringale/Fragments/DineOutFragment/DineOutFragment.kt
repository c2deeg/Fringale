package com.app.fringale.Fragments.DineOutFragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.fringale.Activities.SearchDineOutScreenActivity.SearchDineOutScreenActivity
import com.app.fringale.Activities.SplashActivity2
import com.app.fringale.R
import com.app.fringale.databinding.FragmentDineOutBinding
import com.app.fringale.databinding.FragmentFringaleBinding


class DineOutFragment : Fragment() {
    private var binding:FragmentDineOutBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDineOutBinding.inflate(inflater, container, false)
        val view: View = binding!!.root

        Handler(Looper.getMainLooper()).postDelayed({
            val intent2 = Intent(activity, SearchDineOutScreenActivity::class.java)
            startActivity(intent2)

        }, 1000)
        return view



    }


}