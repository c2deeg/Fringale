package com.app.fringale.Fragments.HomeFragment.Presenter

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Adapter.AllRestaurantsRecyclerAdapter
import com.app.fringale.Fragments.HomeFragment.View.HomeView
import com.app.fringale.Handler.GetAllRestaurantsHandler
import com.app.fringale.Models.GetAllRestaurantsExample
import com.app.fringale.Utils.Utils
import com.app.fringale.Utils.WebServices

class HomePresenter(
    private val activity: FragmentActivity,
    private val homeview: HomeView,
    private val  allrestaurantsrecyclerview: RecyclerView
) {
    private var allRestaurantsRecyclerAdapter:AllRestaurantsRecyclerAdapter?=null

    fun getallRestaurantMethod(token: String, pagenum: Int,pageSize:Int) {


        if (Utils.isNetworkConnected(activity!!)) {
            homeview?.showDialog(activity)
            WebServices.Factory1.getInstance()?.getallRestaurantMethod(token, pagenum, pageSize, object :
                GetAllRestaurantsHandler {
                override fun onSuccess(getAllRestaurantsExample: GetAllRestaurantsExample?) {
                    homeview?.hideDialog()
                    if (getAllRestaurantsExample != null) {
                        if (getAllRestaurantsExample!!.isSuccess === true) {


                            allRestaurantsRecyclerAdapter = AllRestaurantsRecyclerAdapter(activity as FragmentActivity,getAllRestaurantsExample.items)
                            allrestaurantsrecyclerview .layoutManager = LinearLayoutManager(activity,
                                LinearLayoutManager.VERTICAL,false)
                            allrestaurantsrecyclerview?.adapter =allRestaurantsRecyclerAdapter


//
                        } else {
                        }
                    } else {
                    }
                }

                override fun onError(message: String?) {
                    homeview?.hideDialog()
                    homeview?.showMessage(activity, message)

                }
            })
        } else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()

        }

    }

}