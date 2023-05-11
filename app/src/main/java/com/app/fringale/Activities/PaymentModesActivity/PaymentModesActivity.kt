package com.app.fringale.Activities.PaymentModesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.fringale.R
import com.app.fringale.databinding.ActivityPaymentModesBinding

class PaymentModesActivity : AppCompatActivity() {
    private var binding:ActivityPaymentModesBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentModesBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
    }
}