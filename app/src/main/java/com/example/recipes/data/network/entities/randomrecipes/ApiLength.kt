package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiLength(
    val number: Int,
    val unit: String
): Parcelable