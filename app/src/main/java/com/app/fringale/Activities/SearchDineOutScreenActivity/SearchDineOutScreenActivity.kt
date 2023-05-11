package com.app.fringale.Activities.SearchDineOutScreenActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.app.fringale.Activities.MainDineOutScreenActivity.MainDineOutScreenActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivitySearchDineOutScreenBinding

class SearchDineOutScreenActivity : AppCompatActivity() {
    private var btnexplorerestaurants:Button?=null
    private var binding:ActivitySearchDineOutScreenBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_dine_out_screen)
        btnexplorerestaurants = findViewById(R.id.btnexplorerestaurants)
        btnexplorerestaurants?.setOnClickListener{
            Utils.movetoActivity(this,MainDineOutScreenActivity())
        }
    }
}