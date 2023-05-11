package com.app.fringale.Activities.FaqActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Adapter.FaqSampleRecyclerAdapter
import com.app.fringale.R
import com.app.fringale.databinding.ActivityFaqBinding

class FaqActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityFaqBinding? = null
    private var faqSampleRecyclerAdapter: FaqSampleRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initrecycler()
        listeners()


    }
    private fun listeners(){
        binding!!.imgback.setOnClickListener(this)
    }

    private fun initrecycler() {
        faqSampleRecyclerAdapter = FaqSampleRecyclerAdapter(this)
        binding!!.faqsamplequerecylerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.faqsamplequerecylerview.adapter = faqSampleRecyclerAdapter

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.imgback->{
                finish()
            }
        }
    }
}