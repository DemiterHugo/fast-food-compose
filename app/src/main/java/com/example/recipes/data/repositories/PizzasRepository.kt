package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Nutrition
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.pizzas.information.ApiMenuItem
import com.example.recipes.data.network.entities.pizzas.information.ApiNutrition

object PizzasRepository {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getPizzas(): List<Pizza>{
        val result = ApiClient.recipeService.getPizzas(apiKey,"pizza",true)
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
        image = images.first(),
        restaurantChain = restaurantChain,
        servingSize = servingSize,
        nutrition = nutrition.asNutrition()
    )
}

fun ApiNutrition.asNutrition(): Nutrition{
    return Nutrition(
        caloricBreakdown = caloricBreakdown,
        calories = calories,
        carbs = carbs,
        fat = fat,
        nutrients = nutrients,
        protein = protein
    )
}