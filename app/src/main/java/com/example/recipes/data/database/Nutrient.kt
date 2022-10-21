package com.example.recipes.data.database

import androidx.room.Entity

//@Entity
data class Nutrient(
    val amount: Double,
    val name: String,
    val percentOfDailyNeeds: Double,
    val unit: String
)