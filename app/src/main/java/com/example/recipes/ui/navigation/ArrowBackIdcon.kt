package com.example.recipes.ui.navigation

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun ArrowBackIcon(onArrowClick: () -> Unit) {
    IconButton(onClick = {onArrowClick() }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
}