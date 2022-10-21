package com.example.recipes.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.R
import com.example.recipes.data.database.Item

@ExperimentalCoilApi
@Composable
fun Thumb(item: Item, modifier: Modifier = Modifier, ratio: Float = 1f) {
    Image(
        painter = rememberImagePainter(item.image),
        contentDescription = stringResource(id = R.string.image),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(ratio)
    )
}