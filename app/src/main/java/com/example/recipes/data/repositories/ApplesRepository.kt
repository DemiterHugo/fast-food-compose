package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.database.Apple
import com.example.recipes.data.database.Result
import com.example.recipes.data.network.ApplesService
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.apple.ApiResult
import com.example.recipes.data.network.entities.apple.SearchResult
import com.example.recipes.data.network.entities.tryCall
import com.example.recipes.data.room.ItemDao
import javax.inject.Inject

class ApplesRepository @Inject constructor(private val applesService: ApplesService) {

    //private val apiKey = BuildConfig.API_KEY
    private var cache: List<Apple> = emptyList()
    private var cacheNames: List<String> = emptyList()

    suspend fun getApples(): Ei<List<Apple>> {

        return tryCall(action = {
            if (cache.isEmpty()) {
                cache = applesService
                    .getApples( "apple", 4)
                    .searchResults.map {
                        it.asApple()
                    }
            }
            cache
        })
    }

    suspend fun getNames(): Ei<List<String>> {
        return tryCall(action = {
            if (cacheNames.isEmpty()) {
                cacheNames =
                    applesService
                    .getApples(query = "apple", number = 4)
                    .searchResults.map {
                        it.asApple()
                    }.map {
                        it.name.split(" ").sortedBy { it.length }.last()
                    }
            }
            cacheNames
        })
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