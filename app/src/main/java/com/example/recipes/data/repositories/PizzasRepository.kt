package com.example.recipes.data.repositories

import android.os.Parcelable
import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Nutrition
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.pizzas.*
import com.example.recipes.data.network.entities.pizzas.ApiPizzas
import kotlinx.parcelize.Parcelize

object PizzasRepository: Repository<Pizza>() {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getPizzas(): List<Pizza> = super.get{
         ApiClient.pizzasService.getPizzas(apiKey,"pizza",true).menuItems.map {
            it.asPizza()
        }
    }
}

fun ApiMenu<ApiPizzas>.asPizza(): Pizza{
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
        caloricBreakdown = caloricBreakdown.asCaloricBreackdown(),
        calories = calories,
        carbs = carbs,
        fat = fat,
        nutrients = nutrients.asNutrients(),
        protein = protein
    )
}
fun List<ApiNutrient>.asNutrients(): List<Nutrient>{
    return this.map {
        it.asNutrient()
    }
}
fun ApiNutrient.asNutrient(): Nutrient{
    return Nutrient(
        amount = amount,
        name =name,
        percentOfDailyNeeds = percentOfDailyNeeds,
        unit = unit
    )
}



fun ApiCaloricBreakdown.asCaloricBreackdown(): CaloricBreakdown{
    return CaloricBreakdown(
        percentCarbs = percentCarbs,
        percentFat = percentFat,
        percentProtein = percentProtein
    )
}

