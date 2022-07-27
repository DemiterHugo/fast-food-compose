package com.example.recipes.data.network.entities.pizzas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ApiServings(
    val number: Double,
    val size: Double,
    val unit: String
):Parcelable