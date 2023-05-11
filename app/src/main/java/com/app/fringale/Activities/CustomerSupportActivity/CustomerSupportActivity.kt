package com.app.fringale.Activities.CustomerSupportActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.R
import com.app.fringale.databinding.ActivityCustomerSupportBinding

class CustomerSupportActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityCustomerSupportBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerSupportBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listener()
    }
    private fun listener(){
        binding!!.imgback.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.imgback->{
                finish()
            }
        }
    }
}