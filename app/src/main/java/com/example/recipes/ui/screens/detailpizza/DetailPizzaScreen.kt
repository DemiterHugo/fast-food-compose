package com.example.recipes.ui.screens.detailpizza

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.screens.common.Thumb

@ExperimentalCoilApi
@Composable
fun DetailPizzaScreen(pizzaId: Int) {
    //var pizza by remember{ mutableStateOf(Pizza(0,"uno","uno","uno","uno","uno"))}
    var pizza by remember { mutableStateOf<Pizza?>(null)}
    LaunchedEffect(Unit){
        pizza =   PizzasRepository.getPizzas().first{it.id == pizzaId }
    }
    pizza?.let {
        DetailPizzaScreen(it)
    }

}

@ExperimentalCoilApi
@Composable
fun DetailPizzaScreen(pizza: Pizza) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = pizza.title)
            })
        }
    ){
        Thumb(pizza = pizza)
    }
}