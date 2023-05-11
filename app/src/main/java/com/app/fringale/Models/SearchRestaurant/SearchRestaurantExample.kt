package com.app.fringale.Models.SearchRestaurant

data class SearchRestaurantExample(
    val `data`: List<Data>,
    val isSuccess: Boolean,
    val message: String,
    val statusCode: Int
)