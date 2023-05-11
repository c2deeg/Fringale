package com.app.fringale.Activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.fringale.Activities.LoginActivtiy.LoginActivtiy
import com.app.fringale.Activities.SplashActivity3.SplashActivity3
import com.app.fringale.Adapter.FoodViewPagerAdapter
import com.app.fringale.Adapter.ViewPagerAdapter
import com.app.fringale.R
import com.app.fringale.StaticModels.ViewPagerAdapterModel
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivitySplash2Binding
import java.util.*


class SplashActivity2 : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivitySplash2Binding?=null
    var foodViewPagerAdapter:FoodViewPagerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplash2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()

    }
    private fun listeners(){
        binding!!.btngetstarted.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btngetstarted->{
                Utils.movetoActivity(this,SplashActivity3())
            }
        }
    }
}