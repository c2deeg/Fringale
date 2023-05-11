package com.app.fringale.Fragments.FoodFragment.View

import android.app.Activity

interface FoodFragmentView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}