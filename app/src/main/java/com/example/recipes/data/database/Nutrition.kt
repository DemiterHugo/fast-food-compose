package com.example.recipes.data.database

import androidx.room.Embedded
import androidx.room.Entity


//@Entity
data class Nutrition(
    @Embedded val caloricBreakdown: CaloricBreakdown,
    val calories: Double,
    val carbs: String,
    val fat: String,
    val nutrients: List<Nutrient>,
    val protein: String
)
