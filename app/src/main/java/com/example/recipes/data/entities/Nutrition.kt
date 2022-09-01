package com.example.recipes.data.entities

import com.example.recipes.data.network.entities.pizzas.information.CaloricBreakdown
import com.example.recipes.data.network.entities.pizzas.information.Nutrient

data class Nutrition(
    val caloricBreakdown: CaloricBreakdown,
    val calories: Double,
    val carbs: String,
    val fat: String,
    val nutrients: List<Nutrient>,
    val protein: String
)
