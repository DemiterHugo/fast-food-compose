package com.example.recipes.data.network

import com.example.recipes.data.network.entities.apple.AppleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApplesService {

    @GET("/food/search?")
    suspend fun getApples(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int
    ): AppleResponse

}