package com.example.recipes.data.entities

import java.net.IDN

data class Sushi(
    override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String? = "1 slice",
    override val nutrition: Nutrition,
): Item
