package com.example.recipes.data.network.entities.apple

import android.os.Parcelable
//import kotlinx.parcelize.Parcelize


//@Parcelize
data class ApiResult(
    val content: String,
    val dataPoints: List<String>,
    val id: Int,
    val image: String,
    val images: List<String>,
    val link: String,
    val name: String,
    val relevance: Double,
    val type: String
) //: Parcelable