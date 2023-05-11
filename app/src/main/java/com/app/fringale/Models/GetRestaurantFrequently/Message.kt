package com.app.fringale.Models.GetRestaurantFrequently

data class Message(
    val __v: Int,
    val _id: String,
    val address: String,
    val avatar: String,
    val city: String,
    val country: String,
    val createdAt: String,
    val email: String,
    val frequent: Int,
    val location: Location,
    val mobileNumber: Long,
    val name: String,
    val pincode: Int,
    val rating: Int,
    val restaurantStatus: String,
    val status: String,
    val updatedAt: String
)