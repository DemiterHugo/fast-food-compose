package com.example.recipes.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NutrientDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nutritionCreatorId: Int,
    val amount: Double,
    val name: String,
    val percentOfDailyNeeds: Double,
    val unit: String
)