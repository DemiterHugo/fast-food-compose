package com.example.recipes.data.network.entities.pizzas.information

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CaloricBreakdown(
    val percentCarbs: Double,
    val percentFat: Double,
    val percentProtein: Double
): Parcelable