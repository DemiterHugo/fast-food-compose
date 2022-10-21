package com.example.recipes.data.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Apple(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @Embedded val results: List<Result>,
    val totalResults: Int,
    val totalResultsVariants: Int,
    val type: String=""
)

