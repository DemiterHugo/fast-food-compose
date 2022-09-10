package com.example.recipes.data.network

import com.example.recipes.data.network.entities.pizzas.ApiMenu
import com.example.recipes.data.network.entities.pizzas.ApiResponse
import com.example.recipes.data.network.entities.pizzas.ApiSushis
import retrofit2.http.GET
import retrofit2.http.Query

interface SushisService {

    @GET("/food/menuItems/search?")
    suspend fun getSushis(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("addMenuItemInformation") addMenuItemInformation: Boolean
    ): ApiResponse<ApiMenu<ApiSushis>>
}