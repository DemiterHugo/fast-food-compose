
package com.example.recipes.ui.screens.recipes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.data.entities.Recipe
import com.example.recipes.data.repositories.RecipesRandomRepository


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun RecipesScreen(){
    // que la primera ves utilice la lista vacia de Recipes pero que las siguientes use esa misma lista en lugar d vover a crear una
    var recipesState by remember { mutableStateOf(emptyList<Recipe>())}

    //se ejecuta cada vez que lo que pasemos por parametro cambie, como el unit no cambia solo se hara una vez en lugar de hacer siempre
    //la peticion en la corrutina al recrearse el composable.
    LaunchedEffect(Unit){
       // recipesState = RecipesRandomRepository.getRecipesRandom()
    }

    RecipesScreen(recipes = recipesState)

}

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun RecipesScreen(recipes: List<Recipe>) {
    LazyVerticalGrid(cells = GridCells.Adaptive(230.dp), contentPadding = PaddingValues(4.dp)){
        items(recipes){
            RecipeItem(it)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RecipeItem(recipe:Recipe) {
    Column(modifier = Modifier.padding(6.dp)){
        Card {
            Image(
                painter = rememberImagePainter(recipe.thumbnail),
                contentDescription = recipe.name,
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 2,
            modifier = Modifier.padding(8.dp, 16.dp)
        )
    }
}

