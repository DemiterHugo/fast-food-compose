package com.example.recipes.data.network.entities.pizzas.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiMenuItem(
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
): Parcelable