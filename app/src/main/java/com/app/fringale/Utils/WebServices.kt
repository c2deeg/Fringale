package com.app.fringale.Utils

import com.app.fringale.Handler.*
import com.app.fringale.Models.GetAllRestaurantsExample
import com.app.fringale.Models.GetCategoryByName.GetCategoryByNameExample
import com.app.fringale.Models.GetRestaurantByid.GetRestaurantByIdExample
import com.app.fringale.Models.GetRestaurantFrequently.GetRestaurantFrequntlyExample
import com.app.fringale.Models.GetRestaurantsItems.GetRestaurantItemsByIdExample
import com.app.fringale.Models.SearchRestaurant.SearchRestaurantExample
import okhttp3.OkHttpClient
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebServices {

    private val TAG = "WebSrvices"
    private lateinit var api: API


    fun create() {
        retrofit =
            Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()

        api = retrofit.create(API::class.java)

    }


    companion object Factory1 {
        private lateinit var mInstance: WebServices

        private lateinit var retrofit: Retrofit

        val base_url = "http://93.188.167.68:4006/api/"

        //        val base_url = "http://93.188.167.68:8004/api/"
        internal var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()


        fun getInstance(): WebServices? {
            mInstance = WebServices()
            return mInstance
        }
    }

    fun apiCreate() {
        api = retrofit.create(API::class.java)
    }


    fun getallRestaurantMethod(token: String?, pagenum:Int,pagesize:Int,getAllRestaurantsHandler: GetAllRestaurantsHandler) {

        apiCreate()
        api?.getallRestaurantsAPI(token!!,pagenum,pagesize)?.enqueue(object : Callback<GetAllRestaurantsExample?> {
            override fun onResponse(call: Call<GetAllRestaurantsExample?>, response: Response<GetAllRestaurantsExample?>) {
                if (response.code() == 200) {
                    getAllRestaurantsHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getAllRestaurantsHandler.onError(message)
                        } else {
                            getAllRestaurantsHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<GetAllRestaurantsExample?>, t: Throwable) {
                getAllRestaurantsHandler.onError(t.message)
            }
        })
    }


    fun getRestaurantByid(  token: String?,id:String, getRestaurantByIdHandler: GetRestaurantByIdHandler) {
        apiCreate()
        api?.getRestaurantById(token!!,id!!)?.enqueue(object : Callback<GetRestaurantByIdExample?> {
            override fun onResponse(call: Call<GetRestaurantByIdExample?>, response: Response<GetRestaurantByIdExample?>) {
                if (response.code() == 200) {
                    getRestaurantByIdHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getRestaurantByIdHandler.onError(message)
                        } else {
                            getRestaurantByIdHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<GetRestaurantByIdExample?>, t: Throwable) {
                getRestaurantByIdHandler.onError(t.message)
            }
        })
    }

    fun getRestaurantFrequently(  token: String?, getRestaurantFrequentlyHandler: GetRestaurantFrequentlyHandler) {
        apiCreate()
        api?.getrestaurantFrequently(token!!)?.enqueue(object :Callback<GetRestaurantFrequntlyExample>{
            override fun onResponse(
                call: Call<GetRestaurantFrequntlyExample>,
                response: Response<GetRestaurantFrequntlyExample>
            ) {
                if (response.code()==200){
                    getRestaurantFrequentlyHandler.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<GetRestaurantFrequntlyExample>, t: Throwable) {
                getRestaurantFrequentlyHandler.onError(t.message)
            }

        })
    }

    fun getSearchRestaurants(token: String?,search:String, getSearchRestaurantHandler: GetSearchRestaurantHandler) {
        apiCreate()
        api?.getrestaurantBySearch(token!!,search!!)?.enqueue(object : Callback<SearchRestaurantExample?> {
            override fun onResponse(call: Call<SearchRestaurantExample?>, response: Response<SearchRestaurantExample?>) {
                if (response.code() == 200) {
                    getSearchRestaurantHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getSearchRestaurantHandler.onError(message)
                        } else {
                            getSearchRestaurantHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<SearchRestaurantExample?>, t: Throwable) {
                getSearchRestaurantHandler.onError(t.message)
            }
        })
    }

    fun getCategoryByName(token: String?,getCategoryByNameHandler: GetCategoryByNameHandler) {
        apiCreate()
        api?.getcategoryByNameAPI(token!!)?.enqueue(object : Callback<GetCategoryByNameExample?> {
            override fun onResponse(
                call: Call<GetCategoryByNameExample?>,
                response: Response<GetCategoryByNameExample?>
            ) {
                if (response.code()==200){
                    getCategoryByNameHandler.onSuccess(response.body())

                }else{
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getCategoryByNameHandler.onError(message)
                        } else {
                            getCategoryByNameHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }

            }

            override fun onFailure(call: Call<GetCategoryByNameExample?>, t: Throwable) {
                getCategoryByNameHandler.onError(t.message)
            }

        })
    }

    fun getRestaurantsitems(token: String?,id:String,veg:Boolean,nonveg:Boolean,fourRating:Boolean,bestSeller:Boolean, getRestaurantsitemsHandler: GetRestaurantsItemsByIDHandler) {
        apiCreate()
        api?.getrestaurantitemByidAPI(token!!,id,veg,nonveg,fourRating,bestSeller)?.enqueue(object : Callback<GetRestaurantItemsByIdExample?> {
            override fun onResponse(
                call: Call<GetRestaurantItemsByIdExample?>,
                response: Response<GetRestaurantItemsByIdExample?>
            ) {
                if (response.code()==200){
                    getRestaurantsitemsHandler.onSuccess(response.body())

                }else{
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getRestaurantsitemsHandler.onError(message)
                        } else {
                            getRestaurantsitemsHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }

            }

            override fun onFailure(call: Call<GetRestaurantItemsByIdExample?>, t: Throwable) {
                getRestaurantsitemsHandler.onError(t.message)

            }

        })
    }



}