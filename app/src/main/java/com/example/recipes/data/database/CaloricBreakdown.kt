package com.example.recipes.data.database

import androidx.room.Entity

//@Entity
data class CaloricBreakdown(
    val percentCarbs: Double,
    val percentFat: Double,
    val percentProtein: Double
)