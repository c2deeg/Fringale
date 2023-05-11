package com.app.fringale.Handler

import com.app.fringale.Models.SearchRestaurant.SearchRestaurantExample

interface GetSearchRestaurantHandler {
    fun onSuccess(searchRestaurantExample: SearchRestaurantExample?)
    fun onError(message: String?)
}