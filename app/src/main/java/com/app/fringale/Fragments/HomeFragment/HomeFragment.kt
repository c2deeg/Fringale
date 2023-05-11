package com.app.fringale.Fragments.HomeFragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.fringale.Activities.AccountSettingActivity
import com.app.fringale.Activities.PickLocationActivity.PickLocationActivity
import com.app.fringale.Activities.SearchRestaurantActivty.SearchRestaurantActivty
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Adapter.AllRestaurantsRecyclerAdapter
import com.app.fringale.Adapter.FeaturedRestaurantsRecyclerViewAdapter
import com.app.fringale.Adapter.PopularitemsRecyclerAdapter
import com.app.fringale.Fragments.HomeFragment.Presenter.HomePresenter
import com.app.fringale.Fragments.HomeFragment.View.HomeView
import com.app.fringale.Fragments.LocationFragment
import com.app.fringale.Location.GPSTracker
import com.app.fringale.R
import com.app.fringale.Utils.Utils
import com.app.fringale.databinding.FragmentHomeBinding
import com.google.android.gms.location.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.io.IOException
import java.util.*


class HomeFragment : Fragment(), View.OnClickListener,HomeView {
    private var binding:FragmentHomeBinding?=null
    private var featuredRestaurantsRecyclerViewAdapter:FeaturedRestaurantsRecyclerViewAdapter?=null
    private var popularitemsRecyclerAdapter:PopularitemsRecyclerAdapter?=null
    private var allRestaurantsRecyclerAdapter:AllRestaurantsRecyclerAdapter?=null
    var drawerLayout: DrawerLayout? = null
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    var mSlideState = false;
    private var gpsTracker: GPSTracker? = null
    private var handler: Handler? = null
    private var latitude = 0.0
    private var longitude = 0.0
    lateinit var lng:String
    lateinit var lat:String
    private val AUTOCOMPLETE_REQUEST_CODE = 1
    private val locationFragment = LocationFragment()
    var bottomSheetDialog: BottomSheetDialog? = null
    private var homePresenter:HomePresenter?=null



    private var fusedLocationProvider: FusedLocationProviderClient? = null
    private val locationRequest: LocationRequest = LocationRequest.create().apply {
        interval = 30
        fastestInterval = 10
        priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        maxWaitTime = 60
    }

    private var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val locationList = locationResult.locations
            if (locationList.isNotEmpty()) {
                //The last location in the list is the newest
                val location = locationList.last()
                Toast.makeText(
                    activity,
                    "Got Location: " + location.toString(),
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        actionBarDrawerToggle = ActionBarDrawerToggle(
            activity,
            drawerLayout, R.string.app_name, R.string.app_name
        )

        binding!!.drawerLayout!!.addDrawerListener(actionBarDrawerToggle!!)
        //        userrole = getArguments().getString("role");
        handler = Handler()

        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(activity as FragmentActivity)

        checkLocationPermission()
        listeners()



        featuredRestaurantsRecyclerViewAdapter = FeaturedRestaurantsRecyclerViewAdapter(activity as FragmentActivity)
        binding!!.featuredrestaurantsrecyclerview .layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL,false)
        binding!!.featuredrestaurantsrecyclerview?.adapter =featuredRestaurantsRecyclerViewAdapter

        popularitemsRecyclerAdapter  = PopularitemsRecyclerAdapter(activity as FragmentActivity)
        binding!!.popularitemsrecyclerview .layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL,false)
        binding!!.popularitemsrecyclerview?.adapter =popularitemsRecyclerAdapter



        handler!!.postDelayed({
            gpsTracker = GPSTracker(activity)
            if (gpsTracker!!.canGetLocation()) {
                gpsTracker!!.location
                latitude = gpsTracker!!.latitude
                longitude = gpsTracker!!.longitude
            }
//            progressBarNearMe!!.progress
             lng = longitude.toString()
             lat = latitude.toString()
//            progressBarNearMe.visibility = View.GONE
//            rv_nearMe.setVisibility(View.VISIBLE)
//            homePresenter.nearMeHotelsMethod(lng, lat)
        }, 500)


        val gcd = Geocoder(activity, Locale.getDefault())
//        progressBarLocation.setVisibility(View.VISIBLE)
//        img_location.setVisibility(View.GONE)
        handler!!.postDelayed({
            try {
                var addresses: List<Address>? = null
                addresses = gcd.getFromLocation(latitude, longitude, 1)
                Toast.makeText(activity, latitude.toString(), Toast.LENGTH_SHORT).show()

                val finalAddresses = addresses
//                img_location.setVisibility(View.VISIBLE)
//                progressBarLocation.setVisibility(View.GONE)
                if (finalAddresses!!.size > 0) {
                    val cityName = finalAddresses!![0].locality
                    binding!!.tvcityname.setText(cityName)
                } else {
                    Toast.makeText(activity, "couldn't find location", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }, 900)


        homePresenter = HomePresenter(activity as FragmentActivity ,this , binding!!.allrestaurantsrecyclerview)

        homePresenter!!.
        getallRestaurantMethod("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
            1,10000)

        binding?.etsearchview?.setOnClickListener{
           var intent = Intent(activity,SearchRestaurantActivty::class.java)
            startActivity(intent)

        }

        return view
    }
    private fun listeners(){
        binding!!.imgmenu.setOnClickListener(this)
        binding!!.tvcityname.setOnClickListener(this)

    }



    fun clickEventSlide() {
        if (mSlideState) {
            binding!!.drawerLayout.closeDrawer(Gravity.LEFT)
        } else {
            binding!!.drawerLayout.openDrawer(Gravity.LEFT)
        }
    }








    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                activity as FragmentActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity as FragmentActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                AlertDialog.Builder(activity as FragmentActivity)
                    .setTitle("Location Permission Needed")
                    .setMessage("This app needs the Location permission, please accept to use location functionality")
                    .setPositiveButton(
                        "OK"
                    ) { _, _ ->
                        //Prompt the user once explanation has been shown
                        requestLocationPermission()
                    }
                    .create()
                    .show()
            } else {
                // No explanation needed, we can request the permission.
                requestLocationPermission()
            }
        } else {
            checkBackgroundLocation()
        }
    }

    private fun checkBackgroundLocation() {
        if (ActivityCompat.checkSelfPermission(
                activity as FragmentActivity,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestBackgroundLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            activity as FragmentActivity,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            MY_PERMISSIONS_REQUEST_LOCATION
        )
    }

    private fun requestBackgroundLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(
                activity as FragmentActivity,
                arrayOf(
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                ),
                MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION
            )
        } else {
            ActivityCompat.requestPermissions(
                activity as FragmentActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_REQUEST_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(
                            activity as FragmentActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        fusedLocationProvider?.requestLocationUpdates(
                            locationRequest,
                            locationCallback,
                            Looper.getMainLooper()
                        )

                        // Now check background location
                        checkBackgroundLocation()
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(activity, "permission denied", Toast.LENGTH_LONG).show()

                    // Check if we are in a state where the user has denied the permission and
                    // selected Don't ask again
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            activity as FragmentActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    ) {
                        startActivity(
                            Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", activity!!.packageName, null),
                            ),
                        )
                    }
                }
                return
            }
            MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(
                            activity as FragmentActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        fusedLocationProvider?.requestLocationUpdates(
                            locationRequest,
                            locationCallback,
                            Looper.getMainLooper()
                        )

                        Toast.makeText(
                            activity as FragmentActivity,
                            "Granted Background Location Permission",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(activity as FragmentActivity, "permission denied", Toast.LENGTH_LONG).show()
                }
                return

            }
        }
    }

 

    companion object {
        private const val MY_PERMISSIONS_REQUEST_LOCATION = 99
        private const val MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION = 66
    }

    override fun showMessage(activity: Activity?, msg: String?) {

    }

    override fun showDialog(activity: Activity?) {
    }

    override fun hideDialog() {
    }
    override fun onClick(p0: View?) {
        when(p0!!.id){

            R.id.imgmenu->{
                clickEventSlide()
            }
            R.id.tvcityname->{
//                showsongsplaylist()

                Utils.movetoActivity(activity as FragmentActivity, PickLocationActivity())

                activity!!.overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );


            }

        }
    }


}