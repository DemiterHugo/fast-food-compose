package com.example.recipes.data.entities

interface Item {
    val id: Int
    val price: String
    val title: String
    val image: String
    val restaurantChain: String
    val servingSize: String?
    val nutrition: Nutrition
}