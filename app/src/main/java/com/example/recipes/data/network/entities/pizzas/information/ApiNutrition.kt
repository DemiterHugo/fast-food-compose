package com.example.recipes.data.network.entities.pizzas

import android.os.Parcelable
//import kotlinx.parcelize.Parcelize

//@Parcelize
data class ApiNutrition(
    val caloricBreakdown: ApiCaloricBreakdown,
    val calories: Double,
    val carbs: String,
    val fat: String,
    val nutrients: List<ApiNutrient>,
    val protein: String
) //: Parcelable