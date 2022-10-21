package com.example.recipes.data.network.entities.pizzas

import android.os.Parcelable
import com.example.recipes.data.network.entities.pizzas.ApiNutrition
// import kotlinx.parcelize.Parcelize

//@Parcelize
data class ApiMenu<T>(
    val badges: List<String> = emptyList(),
    val breadcrumbs: List<String>,
    val generatedText: String,
    val id: Int,
    val image: String,
    val imageType: String,
    val images: List<String>,
    val likes: Double,
    val numberOfServings: Double,
    val nutrition: ApiNutrition,
    val price: Int,
    val readableServingSize: String,
    val restaurantChain: String,
    val servingSize: String,
    val servings: Servings,
    val spoonacularScore: String,
    val title: String
) //: Parcelable


