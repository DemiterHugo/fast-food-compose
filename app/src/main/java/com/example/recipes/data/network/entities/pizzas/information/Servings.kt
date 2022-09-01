package com.example.recipes.data.network.entities.pizzas.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Servings(
    val number: Double,
    val size: Double,
    val unit: String
): Parcelable