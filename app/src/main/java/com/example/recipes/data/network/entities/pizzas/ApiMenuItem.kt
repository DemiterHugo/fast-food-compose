package com.example.recipes.data.network.entities.pizzas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ApiMenuItem(

    val id: Int,
    val image: String,
    val imageType: String,
    val readableServingSize: String,
    val restaurantChain: String,
    val servingSize: String?,
    val servings: ApiServings,
    val title: String
):Parcelable