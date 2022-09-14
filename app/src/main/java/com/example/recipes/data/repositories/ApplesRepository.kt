package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Apple
import com.example.recipes.data.entities.Result
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.apple.ApiResult
import com.example.recipes.data.network.entities.apple.SearchResult

object ApplesRepository{

    private val apiKey = BuildConfig.API_KEY
    private var cache: List<Apple> = emptyList()

    suspend fun getApples(): List<Apple>{
        if (cache.isEmpty()){
            cache = ApiClient.applesService.getApples(apiKey,"apple",4).searchResults.map {
                it.asApple()
            }
        }
        return cache
    }
}

fun SearchResult.asApple(): Apple = Apple(
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