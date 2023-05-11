package com.app.fringale.Fragments.FoodFragment.Presenter

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Adapter.ExploreRestaurantsRecyclerAdapter
import com.app.fringale.Adapter.FoodScreenFoodCategoriesRecyclerAdapter
import com.app.fringale.Adapter.GetQuicklyRestaurantRecyclerAdapter
import com.app.fringale.Fragments.FoodFragment.View.FoodFragmentView
import com.app.fringale.Handler.GetAllRestaurantsHandler
import com.app.fringale.Handler.GetCategoryByNameHandler
import com.app.fringale.Handler.GetRestaurantFrequentlyHandler
import com.app.fringale.Models.GetAllRestaurantsExample
import com.app.fringale.Models.GetCategoryByName.GetCategoryByNameExample
import com.app.fringale.Models.GetRestaurantFrequently.GetRestaurantFrequntlyExample
import com.app.fringale.Utils.Utils
import com.app.fringale.Utils.WebServices

class FoodFragmentPresenter(
    private val activity: FragmentActivity,
    private val foodView: FoodFragmentView,
    private val explorerestaurantsrecyclerview: RecyclerView,
    private val getQuicklyRestaurantRecyclerView: RecyclerView
) {
    private var exploreRestaurantsRecyclerAdapter: ExploreRestaurantsRecyclerAdapter? = null
    private var getQuicklyRestaurantRecyclerAdapter: GetQuicklyRestaurantRecyclerAdapter? = null
    private var foodScreenFoodCategoriesRecyclerAdapter:FoodScreenFoodCategoriesRecyclerAdapter?=null


    fun getallRestaurantMethod(token: String, pagenum: Int, pageSize: Int) {
        if (Utils.isNetworkConnected(activity!!)) {
//            foodView?.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.getallRestaurantMethod(token, pagenum, pageSize, object :
                    GetAllRestaurantsHandler {
                    override fun onSuccess(getAllRestaurantsExample: GetAllRestaurantsExample?) {
                        foodView?.hideDialog()
                        if (getAllRestaurantsExample != null) {
                            if (getAllRestaurantsExample!!.isSuccess === true) {
                                exploreRestaurantsRecyclerAdapter =
                                    ExploreRestaurantsRecyclerAdapter(
                                        activity as FragmentActivity,
                                        getAllRestaurantsExample.items
                                    )
                                explorerestaurantsrecyclerview.layoutManager = LinearLayoutManager(
                                    activity,
                                    LinearLayoutManager.VERTICAL,
                                    false
                                )
                                explorerestaurantsrecyclerview.adapter =
                                    exploreRestaurantsRecyclerAdapter

                            } else {
                            }
                        } else {
                        }
                    }

                    override fun onError(message: String?) {
                        foodView?.hideDialog()
                        foodView?.showMessage(activity, message)

                    }
                })
        } else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()

        }

    }

    fun getallRestaurantFrequently(token: String) {
        if (Utils.isNetworkConnected(activity!!)) {
//            foodView?.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.getRestaurantFrequently(token, object :
                    GetRestaurantFrequentlyHandler {
                    override fun onSuccess(getRestaurantFrequntlyExample: GetRestaurantFrequntlyExample?) {
                        if (getRestaurantFrequntlyExample != null && getRestaurantFrequntlyExample.isSuccess == true) {
                            Utils.hideDialog()
                            getQuicklyRestaurantRecyclerAdapter =
                                GetQuicklyRestaurantRecyclerAdapter(
                                    activity as FragmentActivity,
                                    getRestaurantFrequntlyExample.data
                                )
                            getQuicklyRestaurantRecyclerView.layoutManager =
                                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                            getQuicklyRestaurantRecyclerView.adapter =
                                getQuicklyRestaurantRecyclerAdapter
                        }
                    }

                    override fun onError(message: String?) {
                        foodView.showMessage(activity, message)
                        Utils.hideDialog()

                    }

                })
        } else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()

        }

    }

    fun getCategoryByName(foodScreenFoodCategoriesRecyclerView: RecyclerView) {
        if (Utils.isNetworkConnected(activity)) {
            foodView.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.getCategoryByName("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2E0MDI5Y2NjY2IwMDZiNWI3NTZjNDAiLCJpYXQiOjE2NzE2OTI5ODh9.Cyi1RfWPCXrA2dva5kFqdRvnaB1lK_7BB6bBYF4FC3M",
                    object : GetCategoryByNameHandler {
                        override fun onSuccess(getCategoryByNameExample: GetCategoryByNameExample?) {
                            if (getCategoryByNameExample != null) {
                                foodView.hideDialog()
                                foodView.showMessage(activity, getCategoryByNameExample.message)
                                foodScreenFoodCategoriesRecyclerAdapter = FoodScreenFoodCategoriesRecyclerAdapter(activity as FragmentActivity,getCategoryByNameExample.data)

                                foodScreenFoodCategoriesRecyclerView.layoutManager =
                                    GridLayoutManager(activity, 2, RecyclerView.HORIZONTAL, false)

                                foodScreenFoodCategoriesRecyclerView.adapter = foodScreenFoodCategoriesRecyclerAdapter

                            }
                        }

                        override fun onError(message: String?) {
                            foodView.showMessage(activity, message)
                            Utils.hideDialog()

                        }

                    })
        }

    }


}