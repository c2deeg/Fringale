package com.app.fringale.Handler

import com.app.fringale.Models.GetRestaurantByid.GetRestaurantByIdExample

interface GetRestaurantByIdHandler {

    fun onSuccess(getRestaurantByIDExample: GetRestaurantByIdExample?)
    fun onError(message: String?)
}