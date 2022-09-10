package com.example.recipes.data.network.entities.apple

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AppleResponse(
    val activeFilterOptions: List<String>,
    val expires: Long,
    val filterMapping: FilterMapping,
    val filterOptions: List<String>,
    val limit: Int,
    val offset: Int,
    val query: String,
    val searchResults: List<SearchResult>,
    val sorting: String,
    val totalResults: Int
): Parcelable