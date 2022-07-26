package com.example.recipes.data.repositories

import com.example.recipes.BuildConfig
import com.example.recipes.data.entities.Recipe
import com.example.recipes.data.network.ApiClient
import com.example.recipes.data.network.entities.randomrecipes.ApiRecipe

object RecipesRandomRepository {

    private val apiKey = BuildConfig.API_KEY

    suspend fun getRecipesRandom(): List<Recipe>{
        val result = ApiClient.recipeService.getRandomRecipes(apiKey, 5, "dessert")
        return result.recipes.map {
            it.asRecipe()
        }
    }
}

fun ApiRecipe.asRecipe(): Recipe = Recipe(
    id = id,
    name = title,
    description = summary,
    thumbnail = image
)

val recipes = (1..10).map {
    Recipe(id = it, name = "Name $it", description = "description $it", thumbnail = "https://spoonacular.com/recipeImages/715449-556x370.jpg")
}