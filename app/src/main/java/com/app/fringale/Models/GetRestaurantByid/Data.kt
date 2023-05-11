package com.app.fringale.Models.GetRestaurantByid

data class Data(
    val _id: String,
    val address: String,
    val avatar: String,
    val bestSeller: String,
    val city: String,
    val country: String,
    val email: String,
    val fourRating: String,
    val frequent: Int,
    val location: Location,
    val mobileNumber: Int,
    val name: String,
    val non_veg: String,
    val pincode: Int,
    val restaurantStatus: String,
    val status: String,
    val veg: String
)