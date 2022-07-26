package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiAnalyzedInstruction(
    val name: String,
    val steps: List<ApiStep>
):Parcelable