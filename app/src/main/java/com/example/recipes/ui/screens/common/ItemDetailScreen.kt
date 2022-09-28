package com.example.recipes.ui.screens.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Item
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.ui.screens.common.Thumb
import com.example.recipes.ui.screens.detailpizza.ItemDetailScaffold


@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun ItemDetailScreen(loading: Boolean = false, item: Ei<Item?>) {

    if (loading){
        CircularProgressIndicator()
    }

    item.fold({ErrorMessage(it)}){ item ->
        if (item != null){
            ItemDetailScaffold(item = item){
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)){
                    item {
                        Header(item)
                    }
                    infoNutrients("Nutrients",item)
                }
            }
        }
    }



}

@ExperimentalMaterialApi
fun LazyListScope.infoNutrients(tite: String, item: Item){
    if (item.nutrition.nutrients.isEmpty()) return
    item {
        Text(text = tite, style = MaterialTheme.typography.h4)
    }
    items(item.nutrition.nutrients){
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
fun Header(item: Item) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Thumb(item = item)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = item.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = item.restaurantChain)
        Spacer(modifier = Modifier.height(16.dp))
    }
}