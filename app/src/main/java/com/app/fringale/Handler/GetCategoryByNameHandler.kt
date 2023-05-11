package com.app.fringale.Handler

import com.app.fringale.Models.GetCategoryByName.GetCategoryByNameExample

interface GetCategoryByNameHandler {
    fun onSuccess(getCategoryByNameExample: GetCategoryByNameExample?)
    fun onError(message: String?)
}