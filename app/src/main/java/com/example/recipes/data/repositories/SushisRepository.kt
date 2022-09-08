package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Item
import com.example.recipes.data.entities.Sushi
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.pizzas.ApiMenu
import com.example.recipes.data.network.entities.pizzas.information.ApiSushis

object SushisRepository: Repository<Sushi>(){

    private val apiKey = BuildConfig.API_KEY

    suspend fun getSushis(): List<Sushi> = super.get{
        ApiClient.sushisService.getSushis(apiKey,"sushi",true).menuItems.map {
            it.asSushi()
        }
    }
}

fun ApiMenu<ApiSushis>.asSushi(): Sushi {
    return Sushi(
        id = id,
        price = "${(id/100000)*10} €",
        title = title,
        image = images.first(),
        restaurantChain = restaurantChain,
        servingSize = servingSize,
        nutrition = nutrition.asNutrition()
    )
}
