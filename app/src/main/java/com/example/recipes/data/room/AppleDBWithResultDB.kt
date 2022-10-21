package com.example.recipes.data.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class AppleDBWithResultDB(
    @Embedded val appleDB: AppleDB,
    @Relation(
        parentColumn = "id",
        entityColumn = "appleCreatorId"
    )
    val results: List<ResultDB>
)
