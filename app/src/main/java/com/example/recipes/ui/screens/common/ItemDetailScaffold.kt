package com.example.recipes.ui.screens.detailpizza

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import com.example.recipes.data.entities.Item
import com.example.recipes.data.entities.Pizza
import com.example.recipes.ui.navigation.ArrowBackIcon

@ExperimentalMaterialApi
@Composable
fun ItemDetailScaffold(item: Item, onArrowClick: () -> Unit, content: @Composable (PaddingValues) -> Unit) {

    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = item.title) },
                navigationIcon = { ArrowBackIcon { onArrowClick() }},
                actions = {
                    AppBarOverFlowMenu(item)
                }
            )
        },
        floatingActionButton = {
            if (item.image.isNotBlank()) {
                FloatingActionButton(onClick = { sharePizza(context = context, item = item) }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = null)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar ={
              BottomAppBar(cutoutShape = CircleShape) {

                  AppBarIcon(imageVector = Icons.Default.Medication, onClickIcon = {/* TODO */})
                  Spacer(modifier = Modifier.weight(1f))
                  AppBarIcon(imageVector = Icons.Default.AccountBalance, onClickIcon = {/* TODO */})

              }
        },
        content = content
    )
}


fun sharePizza(context: Context, item: Item){
    ShareCompat
        .IntentBuilder(context)
        .setType("text/plain")
        .setSubject(item.title)
        .setText(item.image)
        .intent
        .also { context.startActivity(it) }
}