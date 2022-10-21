package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.database.Sushi
import com.example.recipes.data.network.SushisService
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.pizzas.ApiMenu
import com.example.recipes.data.network.entities.pizzas.ApiSushis
import javax.inject.Inject

class SushisRepository @Inject constructor(private val sushisService: SushisService) : Repository<Sushi>() {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getSushis(): Ei<List<Sushi>> = super.get {
        sushisService.getSushis(apiKey, "sushi", true).menuItems.map {
            it.asSushi()
        }
    }

    suspend fun findSushiById(id: Int): Ei<Sushi> {
        return super.findById(id, actionRemote = {
            sushisService.getSushis(apiKey, "sushi", true).menuItems.map {
                it.asSushi()
            }.first { it.id == id }
        })
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
