package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Apples
import com.example.recipes.data.entities.Result
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.apple.ApiResult
import com.example.recipes.data.network.entities.apple.SearchResult

object ApplesRepository{

    private val apiKey = BuildConfig.API_KEY
    private var cache: List<Apples> = emptyList()

    suspend fun getApples(): List<Apples>{
        if (cache.isEmpty()){
            cache = ApiClient.applesService.getApples(apiKey,"apple",4).searchResults.map {
                it.asApple()
            }
        }
        return cache
    }
}

fun SearchResult.asApple(): Apples = Apples(
    name = name,
    results = results.asResults(),
    totalResults = totalResults,
    totalResultsVariants = totalResultsVariants,
    type = type
)

fun List<ApiResult>.asResults(): List<Result>{
    return this.map {
        it.asResult()
    }
}
fun ApiResult.asResult(): Result = Result(
    content = content,
    id = id,
    image = image,
    link = link,
    name = name,
    relevance = relevance,
    type = type
)