package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiMetric(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
):Parcelable