package com.example.recipes.ui.screens.burgers

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
fun BurgersScreen(onClicked2: (id: Int) -> Unit, viewModel: BurgersViewModel = viewModel()) {

    ItemsListScreen(
        loading = viewModel.state.loading,
        items = viewModel.state.items
    ) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun BurgerDetailScreen(viewModel: BurgersDetailViewModel = viewModel()) {

    ItemDetailScreen(loading = viewModel.state.loading, item = viewModel.state.burger)

}