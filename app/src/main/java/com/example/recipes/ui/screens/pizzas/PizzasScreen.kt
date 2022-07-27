package com.example.recipes.ui.screens.pizzas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen() {
    // que la primera ves utilice la lista vacia de Recipes pero que las siguientes use esa misma lista en lugar d vover a crear una
    var pizzasState by remember{ mutableStateOf(emptyList<Pizza>())}

    LaunchedEffect(true){
        pizzasState = PizzasRepository.getPizzas()
    }
    PizzasScreen(pizzas= pizzasState)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(pizzas: List<Pizza>){
    LazyVerticalGrid(cells = GridCells.Adaptive(200.dp), contentPadding = PaddingValues(10.dp)){
        items(pizzas){
            PizzaItem(it)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun PizzaItem(pizza: Pizza) {
    Column(modifier = Modifier.padding(6.dp)) {
        Card(modifier = Modifier.width(200.dp)) {
            Image(
                painter = rememberImagePainter(pizza.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),

                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = pizza.title, maxLines = 2)
    }
}

// con la libreria Navigation Compose podemos navegar entre composables.
//para el sistema clasico de vista tenemos la libreria Jetpack Navigation. Su variante para compose
//se llama Compose Navigation.
