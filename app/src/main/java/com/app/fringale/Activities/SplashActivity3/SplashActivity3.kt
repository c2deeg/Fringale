package com.app.fringale.Activities.SplashActivity3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.Activities.LoginActivtiy.LoginActivtiy
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivitySplash3Binding

class SplashActivity3 : AppCompatActivity(), View.OnClickListener {
    private var biniding: ActivitySplash3Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biniding = ActivitySplash3Binding.inflate(layoutInflater)
        setContentView(biniding!!.root)
        listeners()
    }
    private fun listeners(){
        biniding!!.btngetstarted.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btngetstarted->{
                Utils.movetoActivity(this,LoginActivtiy())
            }
        }
    }
}