package com.app.fringale.Activities.PickLocationActivity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.app.fringale.Activities.CurrentlocActivityJava.MapsActivity
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.ActivityPickLocationBinding
import com.app.fringale.databinding.ActivityProfileSettingActivtiyBinding
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import java.util.*

class PickLocationActivity : AppCompatActivity(), View.OnClickListener {

    private var binding:ActivityPickLocationBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickLocationBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        listeners()


        binding!!.drop.setOnClickListener{


            val intent = Autocomplete.IntentBuilder(
                AutocompleteActivityMode.FULLSCREEN, Arrays.asList(
                    Place.Field.ADDRESS_COMPONENTS,
                    Place.Field.NAME,
                    Place.Field.ADDRESS,
                    Place.Field.LAT_LNG
                )
            ).build(this)
            startActivityForResult(intent, 2)


        }


        if (!Places.isInitialized()) {
            Places.initialize(this, "AIzaSyDFPQu9rxw0T1FEkxpeTZMjOawBaqVcJzc")
        }


//        smf = supportFragmentManager.findFragmentById(R.id.my_ides_map) as SupportMapFragment
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        //Runtime permissions
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
        }



    }

    private fun listeners(){
        binding!!.imgdroparrow.setOnClickListener(this)
        binding!!.lincurrentlocation.setOnClickListener(this)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.slide_from_top,R.anim.slide_in_top);

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.imgdroparrow->{
                finish()
                overridePendingTransition(R.anim.slide_from_top,R.anim.slide_in_top)
            }
            R.id.lincurrentlocation->{
                Utils.movetoActivity(this,MapsActivity())

            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (data!=null){
                val place = data?.let { Autocomplete.getPlaceFromIntent(it) }
                Log.i(
                    "TAGTAGTAG",
                    "Place: " + place?.name + ", " + place?.address + ", " + place?.latLng?.latitude
                )
                val adddress = place?.address
            }
            try {

            } catch (e: Exception) {
            }

        } else if (requestCode == 2) {
            try {
                val place = data?.let { Autocomplete.getPlaceFromIntent(it) }
                val adddress = place?.address
                binding!!.drop.setText(adddress)
//                GetDirection(urll).execute()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}