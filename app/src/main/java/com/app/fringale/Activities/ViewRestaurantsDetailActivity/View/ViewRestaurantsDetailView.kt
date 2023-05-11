package com.app.fringale.Activities.ViewRestaurantsDetailActivity.View

import android.app.Activity
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Models.GetRestaurantByid.Data

interface ViewRestaurantsDetailView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
    fun getData(activity: ViewRestaurantsDetailActivity, data: Data)
//    fun getData(activity: ViewRestaurantsDetailActivity, data: Data)


}