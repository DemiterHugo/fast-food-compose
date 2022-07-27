package com.example.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Recipe
import com.example.recipes.ui.screens.pizzas.PizzasScreen
import com.example.recipes.ui.screens.recipes.RecipesScreen
import com.example.recipes.ui.theme.RecipesTheme

// https://spoonacular.com/food-api/docs

@ExperimentalFoundationApi
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeApp{
                //RecipesScreen()
                PizzasScreen()
            }
        }
    }
}



@Composable
fun RecipeApp(content: @Composable ()-> Unit) {
    RecipesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}