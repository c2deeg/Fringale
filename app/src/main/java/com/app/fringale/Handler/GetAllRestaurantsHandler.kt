package com.app.fringale.Handler

import com.app.fringale.Models.GetAllRestaurantsExample

interface GetAllRestaurantsHandler {
    fun onSuccess(loginExample: GetAllRestaurantsExample?)
    fun onError(message: String?)
}