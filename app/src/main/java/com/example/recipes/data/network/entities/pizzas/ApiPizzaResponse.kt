package com.example.recipes.data.network.entities.pizzas

data class ApiPizzaResponse(
    val expires: Long,
    val menuItems: List<ApiMenuItem>,
    val number: Int,
    val offset: Int,
    val processingTimeMs: Int,
    val totalMenuItems: Int,
    val isState: Boolean,
    val type: String
)