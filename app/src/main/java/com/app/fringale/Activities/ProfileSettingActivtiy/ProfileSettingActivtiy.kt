package com.app.fringale.Activities.ProfileSettingActivtiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.R
import com.app.fringale.databinding.ActivityProfileSettingActivtiyBinding
import com.app.fringale.databinding.ActivitySplash2Binding

class ProfileSettingActivtiy : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivityProfileSettingActivtiyBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingActivtiyBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        listeners()
    }
    private fun listeners(){
        binding!!.imgback.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.imgback->{
                finish()
            }
        }
    }
}