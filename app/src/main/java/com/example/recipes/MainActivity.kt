package com.example.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.FoodApp
import com.example.recipes.ui.navigation.Navigation
import com.example.recipes.ui.theme.RecipesTheme
import com.google.accompanist.pager.ExperimentalPagerApi

// https://spoonacular.com/food-api/docs
// https://api.spoonacular.com/food/menuItems/search?apiKey=e0f3a3ad35ec41db8968e226fa3c06b5&query=sushi&number=2

@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodApp()
        }
    }
}



