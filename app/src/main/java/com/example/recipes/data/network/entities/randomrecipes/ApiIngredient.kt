package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiIngredient(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String
): Parcelable