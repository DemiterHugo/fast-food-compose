package com.example.recipes.data.entities



data class Apple(
    val name: String,
    val results: List<Result>,
    val totalResults: Int,
    val totalResultsVariants: Int,
    val type: String
)

