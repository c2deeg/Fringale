package com.app.fringale.Handler

import com.app.fringale.Models.GetRestaurantFrequently.GetRestaurantFrequntlyExample

interface GetRestaurantFrequentlyHandler {
    fun onSuccess(getRestaurantFrequntlyExample: GetRestaurantFrequntlyExample?)
    fun onError(message: String?)
}