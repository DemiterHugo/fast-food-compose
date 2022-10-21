package com.example.recipes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey



data class Sushi(
    @PrimaryKey(autoGenerate = true) override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String? = "1 slice",
    override val nutrition: Nutrition,
): Item
