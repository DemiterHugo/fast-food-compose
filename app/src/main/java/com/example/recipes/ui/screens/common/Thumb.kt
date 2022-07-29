package com.example.recipes.ui.screens.common

import android.service.controls.templates.ThumbnailTemplate
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.data.entities.Pizza

@ExperimentalCoilApi
@Composable
fun Thumb(pizza: Pizza, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(pizza.image),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),

        contentScale = ContentScale.Crop
    )
}