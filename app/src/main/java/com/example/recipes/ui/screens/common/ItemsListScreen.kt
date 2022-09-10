package com.example.recipes.ui.screens.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.R
import com.example.recipes.data.entities.Item

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun <T: Item>ItemsListScreen(items: List<T>, onClicked1: (id: Int) -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
        }
    ) {
        ItemsList(modifier = Modifier.padding(it), items, onClicked1)
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun <T : Item> ItemsList(
    modifier: Modifier = Modifier,
    items: List<T>,
    onClicked1: (id: Int) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(10.dp),
        modifier = modifier
    ) {
        items(items) {
            ItemList(it) { onClicked1(it.id) }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ItemList(item: Item, onClicked0: ()-> Unit) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable { onClicked0() }
    ){
        Column(modifier = Modifier
            .width(200.dp)
            .padding(0.dp, 8.dp)) {
            Thumb(item = item)
            Text(text = item.title, maxLines = 1, fontSize = 25.sp, textAlign = TextAlign.Center  )
        }
    }
}

