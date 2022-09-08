package com.example.recipes.ui.screens.sushis

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.entities.Sushi
import com.example.recipes.data.repositories.BurgersRepository
import com.example.recipes.data.repositories.SushisRepository
import com.example.recipes.ui.screens.common.ItemsListScreen
import com.example.recipes.ui.screens.detailpizza.ItemDetailScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SushisScreen(onClicked2: (id: Int) -> Unit) {

    var sushisState by rememberSaveable{ mutableStateOf(emptyList<Sushi>()) }

    LaunchedEffect(true){
        sushisState = SushisRepository.getSushis()
    }
    ItemsListScreen(items = sushisState) { onClicked2(it) }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun SushiDetailScreen(sushiId: Int, onArrowClick: () -> Unit) {

    var sushi by remember { mutableStateOf<Sushi?>(null) }
    LaunchedEffect(Unit){
        sushi =   SushisRepository.getSushis().first{it.id == sushiId }
    }
    sushi?.let {
        ItemDetailScreen(it, onArrowClick)
    }
}