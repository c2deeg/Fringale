package com.app.fringale.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.app.fringale.R
import com.app.fringale.databinding.FragmentLoginBinding


class LoginFragment : Fragment(), View.OnClickListener {
    private var binding:FragmentLoginBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view: View = binding!!.root

        listeners()




        return view
    }
    private fun listeners(){
        binding!!.btngetstarted.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btngetstarted->{
                findNavController().navigate(R.id.action_loginFragment_to_otpFragment)
            }

        }
    }


}