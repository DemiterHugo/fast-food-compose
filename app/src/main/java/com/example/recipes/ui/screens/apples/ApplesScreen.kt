package com.example.recipes.ui.screens.apples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.data.entities.Apple
import com.example.recipes.data.repositories.ApplesRepository
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun ApplesScreen(viewModel: ApplesViewModel = viewModel()) {

    val pagerState = rememberPagerState()
    var scope = rememberCoroutineScope()

       Column (){
           if(viewModel.state.apples.isNotEmpty()) {
               ScrollableTabRow(
                   selectedTabIndex = pagerState.currentPage,
                   edgePadding = 0.dp,
                   indicator = { tabPositions ->
                       TabRowDefaults.Indicator(
                           Modifier.pagerTabIndicatorOffset(
                               pagerState,
                               tabPositions
                           )
                       )
                   }
               ) {
                   viewModel.state.names.forEachIndexed { index, name ->
                       Tab(
                           selected = index == pagerState.currentPage,
                           onClick = { scope.launch { pagerState.animateScrollToPage(index)} },
                           text = { Text(text = name) }
                       )
                   }
               }

               HorizontalPager(count = viewModel.state.apples.count(), state = pagerState) {
                   ItemsListForm(apples = viewModel.state.apples, indexPage = pagerState.currentPage)
               }
           }
       }
    }


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun ItemsListForm(apples: List<Apple>, modifier: Modifier = Modifier, indexPage: Int) {

val apple = apples[indexPage]
    Column {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(apple.results) {

                    Card {
                        Column {
                            ListItem(
                                modifier.background(Color.Green.copy(alpha = 0.2f)),
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.Agriculture,
                                        contentDescription = null
                                    )
                                },
                                secondaryText = { Text(text = "Views: ${it.id}") },
                                text = { Text(text = it.name) }
                            )
                            Image(
                                painter = rememberImagePainter(it.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                            )
                            it.content.let { content ->
                                if (content != null) {
                                    Text(text = content.toString(), maxLines = 7 )
                                }
                            }
                        }
                    }
                    Spacer(modifier = modifier.height(12.dp))
            }
        }
    }
}
