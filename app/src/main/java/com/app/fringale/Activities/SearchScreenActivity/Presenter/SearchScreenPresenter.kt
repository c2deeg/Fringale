package com.app.fringale.Activities.SearchScreenActivity.Presenter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.SearchScreenActivity.SearchScreenActivity
import com.app.fringale.Activities.SearchScreenActivity.View.SearchScreenView
import com.app.fringale.Adapter.SearchApiRecylerAdapter
import com.app.fringale.Handler.GetSearchRestaurantHandler
import com.app.fringale.Models.SearchRestaurant.SearchRestaurantExample
import com.app.fringale.Utils.WebServices

class SearchScreenPresenter(
    private val activity: SearchScreenActivity,
    private val searchScreenView: SearchScreenView,
    private val searchreyclerview: RecyclerView?
) {
    private var searchApiRecylerAdapter:SearchApiRecylerAdapter?=null


    fun searchrestaurants(token: String, search: String) {
        WebServices.Factory1.getInstance()
            ?.getSearchRestaurants(token, search, object : GetSearchRestaurantHandler {
                override fun onSuccess(searchRestaurantExample: SearchRestaurantExample?) {
                    if (searchRestaurantExample != null && searchRestaurantExample.isSuccess == true) {
                        if (search.length>0){
                            searchApiRecylerAdapter  = SearchApiRecylerAdapter(activity,searchRestaurantExample.data)
                            searchreyclerview?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
                            searchreyclerview?.adapter = searchApiRecylerAdapter
                            searchScreenView.setData(activity,searchRestaurantExample.data)

                        }else{
                        }

                    }

                }

                override fun onError(message: String?) {
                    searchreyclerview?.visibility = View.GONE

                    searchScreenView.showMessage(activity,message)


                }

            })
    }
}