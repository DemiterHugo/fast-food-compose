package com.example.recipes.data.network.entities.randomrecipes

import android.os.Parcelable
import com.example.recipes.data.network.entities.randomrecipes.ApiEquipment
import com.example.recipes.data.network.entities.randomrecipes.ApiIngredient
import com.example.recipes.data.network.entities.randomrecipes.ApiLength
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiStep(
    val equipments: List<ApiEquipment> = emptyList(),
    val ingredients: List<ApiIngredient>,
    val length: ApiLength,
    val number: Int,
    val step: String
):Parcelable