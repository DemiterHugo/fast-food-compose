package com.example.recipes.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class NutritionDBWithNutrientDB(
    val burgerOwnerId: Int,
    @Embedded val nutrition: NutritionDB,
    @Relation(
        parentColumn = "idNutrition",
        entityColumn = "nutritionCreatorId"
    )
    val nutrients: List<NutrientDB>
)



