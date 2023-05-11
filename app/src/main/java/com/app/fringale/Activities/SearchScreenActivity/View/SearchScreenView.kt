package com.app.fringale.Activities.SearchScreenActivity.View

import android.app.Activity
import com.app.fringale.Activities.SearchScreenActivity.SearchScreenActivity
import com.app.fringale.Models.SearchRestaurant.Data

interface SearchScreenView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
    fun setData(activity: SearchScreenActivity, data: List<Data>)
}