package com.app.fringale.Fragments.ProfileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.app.fringale.Activities.AccountSettingActivity
import com.app.fringale.Activities.ProfileSettingActivtiy.ProfileSettingActivtiy
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.FragmentLoginBinding
import com.app.fringale.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), View.OnClickListener {
    private var binding:FragmentProfileBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view: View = binding!!.root

//        listeners()
        return view
    }
    private fun listeners(){


    }

    override fun onClick(p0: View?) {

        when(p0!!.id){

        }
    }

}