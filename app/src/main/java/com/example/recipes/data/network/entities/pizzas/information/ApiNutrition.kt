package com.example.recipes.data.network.entities.pizzas.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiNutrition(
    val caloricBreakdown: CaloricBreakdown,
    val calories: Double,
    val carbs: String,
    val fat: String,
    val nutrients: List<Nutrient>,
    val protein: String
): Parcelable