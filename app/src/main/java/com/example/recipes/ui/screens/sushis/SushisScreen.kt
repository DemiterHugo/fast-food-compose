package com.example.recipes.ui.screens.sushis

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.screens.common.ItemDetailScreen
import com.example.recipes.ui.screens.common.ItemsListScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SushisScreen(onClicked2: (id: Int) -> Unit, viewModel: SushisViewModel = viewModel()) {

    ItemsListScreen(
        loading = viewModel.state.loading,
        items = viewModel.state.items
    ) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun SushiDetailScreen(viewModel: SushisDetailViewModel = viewModel()) {

        ItemDetailScreen(loading = viewModel.state.loading, item = viewModel.state.sushi)
}