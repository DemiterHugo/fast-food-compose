package com.example.recipes.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BurgerDB(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val price: String,
    val title: String,
    val image: String,
    val restaurantChain: String,
    val servingSize: String? = "1 slice",
    //val nutrition: BurgerDBAndNutrition
)
