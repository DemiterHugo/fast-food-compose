package com.example.recipes.data.repositories

import android.util.Log
import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.pizzas.ApiBugers
import com.example.recipes.data.network.entities.pizzas.ApiMenu

object BurgersRepository: Repository<Burger>() {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getBurgers(): Ei<List<Burger>> {
        return super.get(getAction = {
            ApiClient.burgersService.getBurgers(apiKey, "burger", true)
                .menuItems.map {
                    it.asBurger()
                }
        })
    }

    suspend fun findBurgerById(id: Int): Ei<Burger>{
        return super.findById(
            id,
            actionRemote ={
                ApiClient.burgersService.getBurgers(apiKey, "burger", true)
                    .menuItems.map {
                        it.asBurger()
                    }.first{it.id == id}
            }

        )
    }
}

fun ApiMenu<ApiBugers>.asBurger(): Burger {

    val b = Burger(
        id = id,
        price = "${(id/100000)*10} €",
        title = title,
        image = images.first(),
        restaurantChain = restaurantChain,
        servingSize = servingSize,
        nutrition = nutrition.asNutrition()
    )
    Log.i("ID DE AMBURGUESA",b.toString())
    return b
}

