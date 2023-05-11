package com.app.fringale.Models.GetRestaurantsItems

data class Item(
    val _id: String,
    val avatar: String,
    val createdAt: String,
    val discount: Int,
    val itemDesc: String,
    val itemName: String,
    val price: Int,
    val ratings: String,
    val restaurant: String,
    val status: String,
    val subject: String,
    val updatedAt: String,
    val vegType: String
)