package com.example.recipes.ui.screens.detailpizza

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Medication
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppBarIcon(imageVector: ImageVector, onClickIcon: ()-> Unit){
    IconButton(onClick = { onClickIcon}) {
        Icon(imageVector = Icons.Default.Medication, contentDescription =null )
    }
}