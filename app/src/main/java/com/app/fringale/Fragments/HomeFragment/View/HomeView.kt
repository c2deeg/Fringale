package com.app.fringale.Fragments.HomeFragment.View

import android.app.Activity

interface HomeView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}