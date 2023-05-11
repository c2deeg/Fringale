package com.app.fringale.Utils

import com.app.fringale.Models.GetAllRestaurantsExample
import com.app.fringale.Models.GetCategoryByName.GetCategoryByNameExample
import com.app.fringale.Models.GetRestaurantByid.GetRestaurantByIdExample
import com.app.fringale.Models.GetRestaurantFrequently.GetRestaurantFrequntlyExample
import com.app.fringale.Models.GetRestaurantsItems.GetRestaurantItemsByIdExample
import com.app.fringale.Models.SearchRestaurant.SearchRestaurantExample
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("restaurants/getAllRestaurants")
    fun getallRestaurantsAPI(@Header ("x-access-token")token:String ,@Query("pageNo")pageNo:Int
      , @Query("pageSize")pageSize :Int): Call<GetAllRestaurantsExample>

    @GET("restaurants/getRestaurantById/{id}")
    fun getRestaurantById(@Header("x-access-token")token: String,@Path("id")id:String):Call<GetRestaurantByIdExample>

    @GET("restaurants/getFrequently")
    fun getrestaurantFrequently(@Header("x-access-token")token: String):Call<GetRestaurantFrequntlyExample>

    //searchHotelapi
    @GET("restaurants/search")
    fun getrestaurantBySearch(@Header("x-access-token")token: String,@Query("search")search: String):Call<SearchRestaurantExample>

    //foodcategorybyname
    @GET("category/getCategories")
    fun getcategoryByNameAPI(@Header("x-access-token")token: String):Call<GetCategoryByNameExample>

    //getrestaurantsanditemBYId
    @GET("items/getItemByRestaurantsId")

    fun getrestaurantitemByidAPI(@Header("x-access-token")token: String,@Query("id")id: String, @Query("veg")veg:Boolean,
                                     @Query("non_veg")non_veg:Boolean,@Query("fourRating")fourRating:Boolean,@Query("bestSeller")bestSeller:Boolean):Call<GetRestaurantItemsByIdExample>

}
