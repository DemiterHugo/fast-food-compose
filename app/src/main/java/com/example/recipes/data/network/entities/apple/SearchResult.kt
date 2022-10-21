package com.example.recipes.data.network.entities.apple

import android.os.Parcelable
//import kotlinx.parcelize.Parcelize


//@Parcelize
data class SearchResult(
    val name: String,
    val results: List<ApiResult>,
    val totalResults: Int,
    val totalResultsVariants: Int,
    val type: String
) //: Parcelable