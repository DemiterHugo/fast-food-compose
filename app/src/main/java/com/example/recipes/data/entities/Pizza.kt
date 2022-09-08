package com.example.recipes.data.entities


data class Pizza(
    override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String,
    override val nutrition: Nutrition,
): Item
