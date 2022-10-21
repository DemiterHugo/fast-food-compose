package com.example.recipes.data.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class AppleDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    //val results: List<ResultDB>,
    val totalResults: Int,
    val totalResultsVariants: Int,
    val type: String=""
)

