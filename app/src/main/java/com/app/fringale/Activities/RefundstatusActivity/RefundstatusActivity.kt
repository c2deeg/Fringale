package com.app.fringale.Activities.RefundstatusActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.CompletedRefundRecylerAdapter
import com.app.fringale.R
import com.app.fringale.databinding.ActivityRefundstatusBinding

class RefundstatusActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityRefundstatusBinding? = null
    private var completedRefundRecylerAdapter: CompletedRefundRecylerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefundstatusBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        completedRefundRecylerAdapter = CompletedRefundRecylerAdapter(this)
        binding!!.comletedrefundrecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.comletedrefundrecyclerview.adapter = completedRefundRecylerAdapter

        listeners()
    }

    private fun listeners(){
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