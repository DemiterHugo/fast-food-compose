package com.example.recipes.data.repositories

import android.util.Log
import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.BurgersService
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.pizzas.ApiBugers
import com.example.recipes.data.network.entities.pizzas.ApiMenu

class BurgersRepository(private val burgersService: BurgersService) : Repository<Burger>() {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getBurgers(): Ei<List<Burger>> {
        return super.get(getAction = {
            burgersService.getBurgers(
                apiKey = apiKey,
                query = "burger",
                addMenuItemInformation = true
            )
                .menuItems.map {
                    it.asBurger()
                }
        })
    }

    suspend fun findBurgerById(id: Int): Ei<Burger> {
        return super.findById(
            id,
            actionRemote = {
                burgersService.getBurgers(apiKey, "burger", true)
                    .menuItems.map {
                        it.asBurger()
                    }.first { it.id == id }
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

