package com.app.fringale.Activities.SearchScreenActivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.SearchScreenActivity.Presenter.SearchScreenPresenter
import com.app.fringale.Activities.SearchScreenActivity.View.SearchScreenView
import com.app.fringale.Adapter.PopularCuisinesRecyclerAdapter
import com.app.fringale.Adapter.PopularinstamartRecylerViewAdapter
import com.app.fringale.Adapter.SearchApiRecylerAdapter
import com.app.fringale.Adapter.TrendingSearchesRecyclerViewAdapter
import com.app.fringale.Models.SearchRestaurant.Data
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivitySearchScreenBinding

class SearchScreenActivity : AppCompatActivity(), TextWatcher,SearchScreenView {
    private var binding:ActivitySearchScreenBinding?=null
    private var trendingSearchesRecyclerViewAdapter:TrendingSearchesRecyclerViewAdapter?=null
    private var popularinstamartRecylerViewAdapter:PopularinstamartRecylerViewAdapter?=null
    private var popularCuisinesRecyclerAdapter:PopularCuisinesRecyclerAdapter?=null
    private var searchScreenPresenter:SearchScreenPresenter?=null
    private var searchApiRecylerAdapter:SearchApiRecylerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchScreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initRecyclers()
        listeners()
        searchScreenPresenter = SearchScreenPresenter(this,this,binding?.searchreyclerview)




    }

    private fun initRecyclers(){



        trendingSearchesRecyclerViewAdapter = TrendingSearchesRecyclerViewAdapter(this)
        binding!!.trendingsearchesrecyclerview.layoutManager = GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false)
        binding!!.trendingsearchesrecyclerview.adapter = trendingSearchesRecyclerViewAdapter


        popularinstamartRecylerViewAdapter = PopularinstamartRecylerViewAdapter(this)
        binding!!.popularintamartrecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding!!.popularintamartrecyclerview.adapter = popularinstamartRecylerViewAdapter

        popularCuisinesRecyclerAdapter = PopularCuisinesRecyclerAdapter(this)
        binding!!.popularcuisinesecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding!!.popularcuisinesecyclerview.adapter = popularCuisinesRecyclerAdapter

    }

    private fun listeners(){
        binding!!.etsearchview.addTextChangedListener(this)

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (binding!!.etsearchview.text.length>0){
            binding!!.searchreyclerview.visibility = View.VISIBLE
            binding!!.nestedscrollview.visibility = View.GONE
            searchScreenPresenter?.searchrestaurants("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                p0.toString())
        }else{
            binding!!.searchreyclerview.visibility = View.GONE
            binding!!.nestedscrollview.visibility = View.VISIBLE

        }

    }

    override fun afterTextChanged(p0: Editable?) {

//        Toast.makeText(this, "aftertext", Toast.LENGTH_SHORT).show()

    }

    override fun showMessage(activity: Activity?, msg: String?) {
        Utils.showMessage(activity,msg)
    }

    override fun showDialog(activity: Activity?) {
       Utils.showDialogMethod(activity,activity?.fragmentManager)
    }

    override fun hideDialog() {
       Utils.hideDialog()
    }

    override fun setData(activity: SearchScreenActivity, data: List<Data>) {
        if (data.size==0){
            binding!!.searchreyclerview.visibility =View.GONE
        }
    }

//    override fun setData(activity: SearchScreenActivity, message: List<Message>) {
//        if (message.size==0){
//            binding!!.searchreyclerview.visibility =View.GONE
//        }
//    }
}