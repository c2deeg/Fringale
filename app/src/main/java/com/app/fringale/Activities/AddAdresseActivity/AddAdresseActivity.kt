package com.app.fringale.Activities.AddAdresseActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.Activities.CurrentlocActivityJava.MapsActivity
import com.app.fringale.Activities.PickLocationActivity.PickLocationActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivityAddAdresseBinding
import com.app.fringale.databinding.ActivityProfileBinding

class AddAdresseActivity : AppCompatActivity(), View.OnClickListener {
    private var binding:ActivityAddAdresseBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAdresseBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()
    }
    private fun listeners(){
        binding!!.tvadresses.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tvadresses->{
                Utils.movetoActivity(this,MapsActivity())
            }
        }
    }
}