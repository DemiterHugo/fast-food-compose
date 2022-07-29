package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.pizzas.ApiMenuItem

object PizzasRepository {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getPizzas(): List<Pizza>{
        val result = ApiClient.recipeService.getPizzas(apiKey,"pizza")
        return result.menuItems.map {
            it.asPizza()
        }
    }
}

fun ApiMenuItem.asPizza(): Pizza{
    return Pizza(
        id = id,
        price = "${(id/100000)*10} €",
        title = title,
        image = image,
        restaurantChain = restaurantChain,
        servingSize = servingSize?: "124g"
    )
}