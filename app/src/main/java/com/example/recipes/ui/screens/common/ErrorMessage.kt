package com.example.recipes.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recipes.data.network.entities.TypeError


@Composable
fun ErrorMessage(typeError: TypeError) {

    val msn = when(typeError){
        TypeError.Connectivity -> "Connectivity Error"
        is TypeError.Server -> "Server Error: ${typeError.code}"
        is TypeError.Unknown -> " Unknown Error: ${typeError.message}"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = msn,
            modifier = Modifier.size(120.dp),
            tint = MaterialTheme.colors.error
        )
        Text(text = msn, textAlign = TextAlign.Center, style = MaterialTheme.typography.h4 )
    }

}