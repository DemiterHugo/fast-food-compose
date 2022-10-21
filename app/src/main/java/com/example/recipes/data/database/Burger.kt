package com.example.recipes.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Burger(
    @PrimaryKey(autoGenerate = true) override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String? = "1 slice",
    @Embedded override val nutrition: Nutrition
): Item
