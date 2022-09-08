package com.example.recipes.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val API_ENDPOINT = "https://api.spoonacular.com/"

object ApiClient {

    /**private val logginInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logginInterceptor)
        .addInterceptor(QueryInterceptor())
        .build()**/

    private val okHttpClient = HttpLoggingInterceptor().run{
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private val restAdapter = Retrofit.Builder()
        .baseUrl(API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    //val recipeService: RecipeService = restAdapter.create(RecipeService::class.java)
    val pizzasService: PizzasService = restAdapter.create()
    val burgersService: BurgersService = restAdapter.create()
    val sushisService: SushisService = restAdapter.create()

}
