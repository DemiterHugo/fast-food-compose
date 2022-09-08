package com.example.recipes.data.entities


data class Burger(
    override val id: Int,
    override val price: String,
    override val title: String,
    override val image: String,
    override val restaurantChain: String,
    override val servingSize: String? = "1 slice",
    override val nutrition: Nutrition
): Item
