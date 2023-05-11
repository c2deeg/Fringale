package com.app.fringale.Activities.MyAccountActivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.fringale.R
import com.app.fringale.databinding.ActivityMyAccountBinding


class MyAccountActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityMyAccountBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyAccountBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()
    }

    private fun listeners() {
        binding!!.tvfavourite.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tvfavourite -> {

            }
        }
    }
}
