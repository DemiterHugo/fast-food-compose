package com.example.recipes.ui.screens.detailpizza

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalUriHandler
import com.example.recipes.data.entities.Item

@ExperimentalMaterialApi
@Composable
fun AppBarOverFlowMenu(item: Item) {
    if (item.image.isEmpty()) return
    var showDropMenu by remember{ mutableStateOf(false) }
    var uriHandler = LocalUriHandler.current

    IconButton(onClick = { showDropMenu = true }) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
        DropdownMenu(expanded = showDropMenu, onDismissRequest = { showDropMenu = false }){
            item.nutrition.nutrients.subList(0,3).forEach {
                DropdownMenuItem(onClick = {
                    uriHandler.openUri(item.image)
                    showDropMenu = false
                }) {
                    ListItem(text = { Text(text = it.name) })
                }
            }
        }
    }
}