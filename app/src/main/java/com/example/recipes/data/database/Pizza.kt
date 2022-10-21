package com.example.recipes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pizza(
    @PrimaryKey(autoGenerate = true) override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String,
    override val nutrition: Nutrition,
): Item
