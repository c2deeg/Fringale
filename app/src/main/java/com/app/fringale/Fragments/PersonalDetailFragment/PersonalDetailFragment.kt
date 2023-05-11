package com.app.fringale.Fragments.PersonalDetailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.app.fringale.Activities.HomeActivity.HomeActivity
import com.app.fringale.Activities.PickLocationActivity.PickLocationActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.FragmentLoginBinding
import com.app.fringale.databinding.FragmentPersonalDetailBinding
import okio.Utf8

class PersonalDetailFragment : Fragment(), View.OnClickListener {
    private var binding: FragmentPersonalDetailBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalDetailBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        listeners()
        return view
    }

    private fun listeners(){
        binding!!.btnalocationaccess.setOnClickListener(this)
        binding!!.tventerlocmanually.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnalocationaccess->Utils.movetoActivity(activity as FragmentActivity,HomeActivity())
            R.id.tventerlocmanually->{
                Utils.movetoActivity(activity as FragmentActivity,PickLocationActivity())
            }


        }
    }

}