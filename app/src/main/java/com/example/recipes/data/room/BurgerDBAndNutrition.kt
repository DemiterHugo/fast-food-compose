package com.example.recipes.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


@Entity
data class BurgerDBAndNutrition(
    @Embedded val burgerDB: BurgerDB,
    @Relation(
        parentColumn = "id",
        entityColumn = "burgerOwnerId"
    )
    val nutrition: NutritionDBWithNutrientDB
)
