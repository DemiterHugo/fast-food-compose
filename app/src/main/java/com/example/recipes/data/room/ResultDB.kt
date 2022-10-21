package com.example.recipes.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ResultDB(
    val content: String?,
    @PrimaryKey(autoGenerate = true) val id: Int,
    val image: String,
    val link: String? = "https://i.ytimg.com/vi/6PtqQNDi5-M/mqdefault.jpg",
    val name: String,
    val relevance: Double,
    val type: String,
    val appleCreatorId: Int
)