package com.example.recipes.ui.screens.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun <T: Item>ItemsListScreen(loading: Boolean = false, items: List<T>, onClicked1: (id: Int) -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (loading) {
            CircularProgressIndicator()
        }
        LazyVerticalGrid(
            cells = GridCells.Adaptive(200.dp),
            contentPadding = PaddingValues(10.dp),
        ) {
            items(items) {
                ItemList(it) { onClicked1(it.id) }
            }
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

