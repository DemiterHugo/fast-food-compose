package com.example.recipes.data.network.entities.pizzas

/*
data class ApiPizzasResponse(
    val expires: Long,
    val menuItems: List<ApiMenuItem>,
    val number: Int,
    val offset: Int,
    val processingTimeMs: Int,
    val totalMenuItems: Int,
    val type: String
)
*/
data class ApiResponse<T>(
    val expires: Long,
    val menuItems: List<T>,
    val number: Int,
    val offset: Int,
    val processingTimeMs: Int,
    val totalMenuItems: Int,
    val type: String
)