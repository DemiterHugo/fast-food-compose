package com.example.recipes.ui.screens.sushis

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.screens.common.ItemDetailScreen
import com.example.recipes.ui.screens.common.ItemsListScreen

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SushisScreen(onClicked2: (id: Int) -> Unit, viewModel: SushisViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    ItemsListScreen(
        loading = state.loading,
        items = state.items
    ) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun SushiDetailScreen(viewModel: SushisDetailViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    ItemDetailScreen(loading = state.loading, item = state.sushi)
}