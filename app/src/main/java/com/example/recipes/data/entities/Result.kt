package com.example.recipes.data.entities


data class Result(
    val content: String?,
    val id: Int,
    val image: String,
    val link: String? = "https://i.ytimg.com/vi/6PtqQNDi5-M/mqdefault.jpg",
    val name: String,
    val relevance: Double,
    val type: String
)