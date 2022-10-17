package com.example.recipes.ui.screens.common

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.R
import com.example.recipes.data.entities.Item
import com.example.recipes.data.network.entities.Ei
import kotlinx.coroutines.launch

const val ITEM_CLICK = "ItemClick"

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun <T: Item>ItemsListScreen(
    loading: Boolean = false,
    items: Ei<List<T>>,
    onClicked1: (id: Int) -> Unit,
) {
    items.fold({ ErrorMessage(typeError = it)}){ listT ->

        var bottomSheetItem by remember{ mutableStateOf<T?>(null)}
        val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val scope = rememberCoroutineScope()

        BackHandler(sheetState.isVisible) {
            scope.launch { sheetState.hide() }
        }

        ModalBottomSheetLayout(
            sheetContent = {
                ItemBottomPreview(
                    item = bottomSheetItem,
                    onGoToDetail = {
                        scope.launch {
                            sheetState.hide()
                            onClicked1(it)
                        }
                    }
                )
            },
            sheetState = sheetState
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                if (loading) {
                    CircularProgressIndicator()
                }
                LazyVerticalGrid(
                    cells = GridCells.Adaptive(200.dp),
                    contentPadding = PaddingValues(10.dp),
                ) {
                    items(listT) {
                        ItemList(
                            item = it,
                            onItemMore = { item ->
                                bottomSheetItem = item
                                scope.launch { sheetState.show() }
                                         },
                            modifier = Modifier.clickable{ onClicked1(it.id) }.testTag(it.title)
                        )
                    }
                }
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
//MarvelListItem

fun <T: Item>ItemList(
    item: T,
    //onClicked0: () -> Unit,
    onItemMore: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(6.dp)
           //.clickable { onClicked0() }
    ){
        Column(modifier = modifier
            .width(200.dp)
            .padding(0.dp, 8.dp)) {
            Thumb(item = item)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.title,
                    maxLines = 1,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { onItemMore(item) }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = stringResource(
                        id = R.string.more_options
                    ))
                }
            }
        }
    }
}

