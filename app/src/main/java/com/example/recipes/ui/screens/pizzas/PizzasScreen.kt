package com.example.recipes.ui.screens.pizzas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.screens.common.Thumb


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(onClicked2: (id: Int) -> Unit) {
    // que la primera ves utilice la lista vacia de Recipes pero que las siguientes use esa misma lista en lugar d vover a crear una
    var pizzasState by rememberSaveable{ mutableStateOf(emptyList<Pizza>())}

    LaunchedEffect(true){
        pizzasState = PizzasRepository.getPizzas()
    }
    PizzasScreen(pizzas= pizzasState, onClicked1 = {onClicked2(it)})
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(pizzas: List<Pizza>,onClicked1: (id: Int) -> Unit){
    LazyVerticalGrid(cells = GridCells.Adaptive(200.dp), contentPadding = PaddingValues(10.dp)){
        items(pizzas){
            PizzaItem(it, onClicked0 = {onClicked1(it.id)})
        }
    }
}

@ExperimentalCoilApi
@Composable
fun PizzaItem(pizza: Pizza, onClicked0: ()-> Unit) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable { onClicked0() }
    ){
        Column(modifier = Modifier
            .width(200.dp)
            .padding(0.dp, 8.dp)) {
            Thumb(pizza = pizza)
            Text(text = pizza.title, maxLines = 1, fontSize = 25.sp, textAlign = TextAlign.Center  )
        }
    }
}
// con la libreria Navigation Compose podemos navegar entre composables.
//para el sistema clasico de vista tenemos la libreria Jetpack Navigation. Su variante para compose
//se llama Compose Navigation.
