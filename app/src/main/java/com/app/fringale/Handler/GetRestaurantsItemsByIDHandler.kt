package com.app.fringale.Handler

import com.app.fringale.Models.GetRestaurantsItems.GetRestaurantItemsByIdExample
import com.app.fringale.Models.SearchRestaurant.SearchRestaurantExample

interface GetRestaurantsItemsByIDHandler {
    fun onSuccess(getRestaurantItemsByIdExample: GetRestaurantItemsByIdExample?)
    fun onError(message: String?)
}