package com.app.fringale.Activities.ViewRestaurantsDetailActivity.Presenter

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.View.ViewRestaurantsDetailView
import com.app.fringale.Activities.ViewRestaurantsDetailActivity.ViewRestaurantsDetailActivity
import com.app.fringale.Adapter.FoodItemsCategoriesAdapter
import com.app.fringale.Handler.GetRestaurantByIdHandler
import com.app.fringale.Handler.GetRestaurantsItemsByIDHandler
import com.app.fringale.Models.GetRestaurantByid.GetRestaurantByIdExample
import com.app.fringale.Models.GetRestaurantsItems.GetRestaurantItemsByIdExample
import com.app.fringale.Utils.Utils
import com.app.fringale.Utils.WebServices
import com.app.fringale.interfaces.NestedClickListener

class ViewRestaurantsDetailPresenter(
    private val viewRestaurantsDetailView: ViewRestaurantsDetailView,
    private val activity: ViewRestaurantsDetailActivity,
    private val listener: NestedClickListener,
    private val fooditemscategoriesrecyclerview: RecyclerView,
) {
    private var  categoriesadapter: FoodItemsCategoriesAdapter?=null


    fun getallRestaurantByIdMethod(token: String, id: String) {
        if (Utils.isNetworkConnected(activity!!)) {
//            viewRestaurantsDetailView?.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.getRestaurantByid(token, id, object :
                    GetRestaurantByIdHandler {
                    override fun onSuccess(getRestaurantByIDExample: GetRestaurantByIdExample?) {
                        viewRestaurantsDetailView?.hideDialog()
                        if (getRestaurantByIDExample != null) {
                            if (getRestaurantByIDExample!!.isSuccess === true) {
                                viewRestaurantsDetailView.showMessage(
                                    activity,
                                    getRestaurantByIDExample.message
                                )
                                viewRestaurantsDetailView.getData(
                                    activity,
                                    getRestaurantByIDExample.data
                                )

                            } else {
                                viewRestaurantsDetailView.showMessage(
                                    activity,
                                    getRestaurantByIDExample.message
                                )

                            }
                        } else {
                            viewRestaurantsDetailView.showMessage(
                                activity,
                                getRestaurantByIDExample?.message
                            )

                        }
                    }

                    override fun onError(message: String?) {
                        viewRestaurantsDetailView?.hideDialog()
                        viewRestaurantsDetailView?.showMessage(activity, message)

                    }
                })
        } else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()

        }

    }


    fun getrestaurntsItemMethod(token: String, id: String,veg:Boolean,nonveg:Boolean,fourRating:Boolean,bestSeller:Boolean) {
        if (Utils.isNetworkConnected(activity!!)) {
            viewRestaurantsDetailView.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.getRestaurantsitems(token, id,veg,nonveg,fourRating,bestSeller, object :
                    GetRestaurantsItemsByIDHandler {
                    override fun onSuccess(getRestaurantItemsByIdExample: GetRestaurantItemsByIdExample?) {
                        if (getRestaurantItemsByIdExample != null) {
                            viewRestaurantsDetailView.hideDialog()
                            if (getRestaurantItemsByIdExample!!.isSuccess === true) {
                                viewRestaurantsDetailView.showMessage(
                                    activity,
                                    getRestaurantItemsByIdExample.message
                                )
                                categoriesadapter = FoodItemsCategoriesAdapter(activity, listener,getRestaurantItemsByIdExample.data)
                                fooditemscategoriesrecyclerview.layoutManager = LinearLayoutManager(
                                    activity,
                                    LinearLayoutManager.VERTICAL, false
                                )
                               fooditemscategoriesrecyclerview?.adapter = categoriesadapter

                            } else {
                                viewRestaurantsDetailView.showMessage(
                                    activity,
                                    getRestaurantItemsByIdExample.message
                                )

                            }
                        } else {
                            viewRestaurantsDetailView.showMessage(
                                activity,
                                getRestaurantItemsByIdExample?.message
                            )

                        }


                    }

                    override fun onError(message: String?) {
                        viewRestaurantsDetailView?.hideDialog()
                        viewRestaurantsDetailView?.showMessage(activity, message)
                    }
                })
        } else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()

        }

    }


}