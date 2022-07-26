package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiExtendedIngredient(
    val aisle: String,
    val amount: Double,
    val consistency: String,
    val id: Int,
    val image: String,
    val measures: ApiMeasures,
    val meta: List<String> = emptyList(),
    val name: String,
    val nameClean: String,
    val original: String,
    val originalName: String,
    val unit: String
): Parcelable