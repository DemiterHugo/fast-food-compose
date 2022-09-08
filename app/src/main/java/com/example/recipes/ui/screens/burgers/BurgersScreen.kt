package com.example.recipes.ui.screens.burgers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.repositories.BurgersRepository
import com.example.recipes.ui.screens.common.ItemsListScreen
import com.example.recipes.ui.screens.detailpizza.ItemDetailScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun BurgersScreen(onClicked2: (id: Int) -> Unit) {

    var burgersState by rememberSaveable{ mutableStateOf(emptyList<Burger>()) }

    LaunchedEffect(true){
        burgersState = BurgersRepository.getBurgers()
    }
    ItemsListScreen(items = burgersState) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun BurgerDetailScreen(burgerId: Int, onArrowClick: () -> Unit) {

    var burger by remember { mutableStateOf<Burger?>(null) }
    LaunchedEffect(Unit){
        burger =   BurgersRepository.getBurgers().first{it.id == burgerId }
    }
    burger?.let {
        ItemDetailScreen(it, onArrowClick)
    }
}