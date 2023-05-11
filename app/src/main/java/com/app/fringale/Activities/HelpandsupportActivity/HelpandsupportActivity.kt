package com.app.fringale.Activities.HelpandsupportActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.Activities.CustomerSupportActivity.CustomerSupportActivity
import com.app.fringale.Activities.FaqActivity.FaqActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivityHelpandsupportBinding

class HelpandsupportActivity : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivityHelpandsupportBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpandsupportBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()
    }
    private fun listeners(){
        binding!!.tvcustomersupport.setOnClickListener(this)
        binding!!.tvfaq.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tvcustomersupport->{
                Utils.movetoActivity(this,CustomerSupportActivity())
            }
            R.id.tvfaq->{
                Utils.movetoActivity(this,FaqActivity())

            }
        }
    }
}