package com.example.recipes.data.network

import com.example.recipes.data.network.entities.pizzas.information.ApiPizzasResponse
import com.example.recipes.data.network.entities.randomrecipes.ApiRandomResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("/recipes/random?")
    suspend fun getRandomRecipes(
        @Query("apiKey") apiKey: String,
        @Query("number") number: Int,
        @Query("tags") tags: String
    ): ApiRandomResponse

    @GET("/food/menuItems/search?")
    suspend fun getPizzas(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("addMenuItemInformation") addMenuItemInformation: Boolean
    ): ApiPizzasResponse

}