package com.example.recipes.ui.screens.pizzas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.screens.common.ItemDetailScreen
import com.example.recipes.ui.screens.common.ItemsListScreen


@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun PizzasScreen(onClicked2: (id: Int) -> Unit, viewModel: PizzasViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    ItemsListScreen(loading = state.loading, items = state.items) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun PizzaDetailScreen(viewModel: PizzasDetailViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()
    ItemDetailScreen(loading = state.loading, item = state.pizza)
}





