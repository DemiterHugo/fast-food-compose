package com.example.recipes.ui.screens.pizzas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.screens.common.ItemDetailScreen
import com.example.recipes.ui.screens.common.ItemsListScreen


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(onClicked2: (id: Int) -> Unit, viewModel: PizzasViewModel = viewModel()) {

   /* var pizzasState by rememberSaveable{ mutableStateOf(emptyList<Pizza>())}

    LaunchedEffect(true){
        pizzasState = PizzasRepository.getPizzas()
    }  */
    ItemsListScreen(loading = viewModel.state.loading, items = viewModel.state.items) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun PizzaDetailScreen(viewModel: PizzasDetailViewModel = viewModel()) {
    
    ItemDetailScreen(loading = viewModel.state.loading, item = viewModel.state.pizza)
}





