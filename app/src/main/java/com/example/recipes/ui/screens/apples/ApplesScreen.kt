package com.example.recipes.ui.screens.apples

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.R
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
fun ApplesScreen() {

    var applesState by rememberSaveable{ mutableStateOf(emptyList<Apple>())}
    var names by rememberSaveable{ mutableStateOf(emptyList<String>()) }
    val pagerState = rememberPagerState()
    var scope = rememberCoroutineScope()

    LaunchedEffect(true){
        applesState = ApplesRepository.getApples()
    }

    names = applesState.map { it.name.split(" ").sortedBy { it.length }.last() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
        }
    ) {
       Column (modifier = Modifier.padding(it)){
           if(applesState.isNotEmpty()) {
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
                   names.forEachIndexed { index, name ->
                       Tab(
                           selected = index == pagerState.currentPage,
                           onClick = { scope.launch { pagerState.animateScrollToPage(index)} },
                           text = { Text(text = name) }
                       )
                   }
               }

               HorizontalPager(count = applesState.count(), state = pagerState) {
                   ItemsListForm(apples = applesState, indexPage = pagerState.currentPage)
               }
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

@Composable
private fun TitleRecycler(
    apples: List<Apple>,
    modifier: Modifier
) {
    Text(
        text = apples.firstOrNull()?.name ?: "Apple recipe",
        modifier.padding(10.dp, 20.dp),
        style = MaterialTheme.typography.h5.copy(
            shadow = Shadow(
                offset = Offset(5f, 5f),
                blurRadius = 5f,
                color = Color.Green.copy(alpha = 0.2f)
            )
        )
    )
}