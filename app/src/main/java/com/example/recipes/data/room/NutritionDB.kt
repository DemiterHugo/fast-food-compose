package com.example.recipes.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NutritionDB(
    @PrimaryKey(autoGenerate = true) val idNutrition: Int = 0,
    val calories: Double,
    val carbs: String,
    val fat: String,
    //val nutrients: List<NutrientDB>,
    val protein: String,
    val percentCarbs: Double,
    val percentFat: Double,
    val percentProtein: Double
)
