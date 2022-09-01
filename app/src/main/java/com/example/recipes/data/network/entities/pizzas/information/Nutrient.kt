package com.example.recipes.data.network.entities.pizzas.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Nutrient(
    val amount: Double,
    val name: String,
    val percentOfDailyNeeds: Double,
    val unit: String
): Parcelable