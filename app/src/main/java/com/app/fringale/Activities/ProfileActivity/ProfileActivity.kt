package com.app.fringale.Activities.ProfileActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fringale.Activities.AddAdresseActivity.AddAdresseActivity
import com.app.fringale.Activities.HelpandsupportActivity.HelpandsupportActivity
import com.app.fringale.Activities.MyAccountActivity.MyAccountActivity
import com.app.fringale.Activities.PaymentModesActivity.PaymentModesActivity
import com.app.fringale.Activities.RefundstatusActivity.RefundstatusActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivityProfileBinding
import com.app.fringale.databinding.ActivitySearchRestaurantActivtyBinding

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityProfileBinding? = null
    private var flag: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()

    }

    private fun listeners() {
        binding!!.tvmyaccount.setOnClickListener(this)
        binding!!.tvadresses.setOnClickListener(this)
        binding!!.tvpaymentrefunds.setOnClickListener(this)
        binding!!.imgdown.setOnClickListener(this)
        binding!!.tvrefundstatus.setOnClickListener(this)
        binding!!.tvpaymentmodes.setOnClickListener(this)
        binding!!.tvhelp.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tvmyaccount -> {
                Utils.movetoActivity(this, MyAccountActivity())
            }
            R.id.tvadresses -> {
                Utils.movetoActivity(this, AddAdresseActivity())
            }
            R.id.imgdown -> {
                if (flag) {
                    binding!!.imgdown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    binding!!.linpayment.visibility = View.VISIBLE
                } else {
                    binding!!.imgdown.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    binding!!.linpayment.visibility = View.GONE
                }
                flag = !flag
            }
            R.id.tvrefundstatus -> {
                Utils.movetoActivity(this, RefundstatusActivity())
            }
            R.id.tvpaymentmodes -> {
                Utils.movetoActivity(this, PaymentModesActivity())
            }
            R.id.tvhelp->{
                Utils.movetoActivity(this,HelpandsupportActivity())
            }
        }
    }
}