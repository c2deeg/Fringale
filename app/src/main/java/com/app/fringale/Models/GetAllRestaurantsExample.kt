package com.app.fringale.Models

data class GetAllRestaurantsExample(
    val isSuccess: Boolean,
    val items: List<Item>,
    val pageNo: Int,
    val pageSize: Int,
    val statusCode: Int,
    val total: Int
)