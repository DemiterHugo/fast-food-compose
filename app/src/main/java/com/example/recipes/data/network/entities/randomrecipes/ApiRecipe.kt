package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import com.example.recipes.data.network.entities.randomrecipes.ApiAnalyzedInstruction
import com.example.recipes.data.network.entities.randomrecipes.ApiExtendedIngredient
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiRecipe(
    val aggregateLikes: Int,
    val analyzedInstructions: List<ApiAnalyzedInstruction>,
    val cheap: Boolean,
    val cookingMinutes: Int,
    val creditsText: String,
    val cuisines: List<String> = emptyList(),
    val dairyFree: Boolean,
    val diets: List<String> = emptyList(),
    val dishTypes: List<String> = emptyList(),
    val extendedIngredients: List<ApiExtendedIngredient>,
    val gaps: String,
    val glutenFree: Boolean,
    val healthScore: Int,
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val license: String,
    val lowFodmap: Boolean,
    val occasions: List<String> = emptyList(),
    val openLicense: Int,
    val originalId: Int?=0,
    val preparationMinutes: Int,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularSourceUrl: String,
    val summary: String,
    val sustainable: Boolean,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: Int
): Parcelable