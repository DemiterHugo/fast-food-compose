package com.example.recipes.data.network

import com.example.recipes.data.network.entities.pizzas.ApiMenu
import com.example.recipes.data.network.entities.pizzas.ApiResponse
import com.example.recipes.data.network.entities.pizzas.ApiBugers
import retrofit2.http.GET
import retrofit2.http.Query

interface BurgersService {

    @GET("/food/menuItems/search?")
    suspend fun getBurgers(
        //@Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("addMenuItemInformation") addMenuItemInformation: Boolean
    ): ApiResponse<ApiMenu<ApiBugers>>
}