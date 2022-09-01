package com.example.recipes.ui.screens.detailpizza

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.navigation.ArrowBackIcon
import com.example.recipes.ui.screens.common.Thumb

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailPizzaScreen(pizzaId: Int, onArrowClick: () -> Unit) {

    var pizza by remember { mutableStateOf<Pizza?>(null)}
    LaunchedEffect(Unit){
        pizza =   PizzasRepository.getPizzas().first{it.id == pizzaId }
    }
    pizza?.let {
        DetailPizzaScreen(it, onArrowClick)
    }

}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailPizzaScreen(pizza: Pizza, onArrowClick: ()-> Unit) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = pizza.title) },
                navigationIcon = { ArrowBackIcon { onArrowClick() }},
                actions = {
                    AppBarOverFlowMenu(pizza)
                }
            )
        }
    ){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            item {
                Header(pizza = pizza)
            }
            infoNutrients("Nutrients",pizza)
        }

    }
}

@ExperimentalMaterialApi
fun LazyListScope.infoNutrients(tite: String, pizza: Pizza){
    if (pizza.nutrition.nutrients.isEmpty()) return
    item {
        Text(text = tite, style = MaterialTheme.typography.h4)
    }
    items(pizza.nutrition.nutrients){
        ListItem(
            icon = { Icon(imageVector = Icons.Default.Image, contentDescription = null) },
            secondaryText = { Text(text = "${it.amount} ${it.unit}")},
            text = { Text(text = it.name) },
        )
        Divider(color = Color.DarkGray, modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@ExperimentalCoilApi
@Composable
fun Header(pizza: Pizza) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Thumb(pizza = pizza)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = pizza.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = pizza.restaurantChain)
        Spacer(modifier = Modifier.height(16.dp))
    }
}