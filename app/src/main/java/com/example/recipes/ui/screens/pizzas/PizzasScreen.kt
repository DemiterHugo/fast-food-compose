package com.example.recipes.ui.screens.pizzas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.screens.common.ItemsListScreen
import com.example.recipes.ui.screens.detailpizza.ItemDetailScreen



@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(onClicked2: (id: Int) -> Unit) {

    var pizzasState by rememberSaveable{ mutableStateOf(emptyList<Pizza>())}

    LaunchedEffect(true){
        pizzasState = PizzasRepository.getPizzas()
    }
    ItemsListScreen(items = pizzasState) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun PizzaDetailScreen(pizzaId: Int, onArrowClick: () -> Unit) {

    var pizza by remember { mutableStateOf<Pizza?>(null)}
    LaunchedEffect(Unit){
        pizza =   PizzasRepository.getPizzas().first{it.id == pizzaId }
    }
    pizza?.let {
        ItemDetailScreen(it, onArrowClick)
    }
}





