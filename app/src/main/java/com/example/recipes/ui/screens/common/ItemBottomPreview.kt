package com.example.recipes.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.recipes.R
import com.example.recipes.data.database.Item
import com.example.recipes.ui.theme.Yelow700Demi


@ExperimentalCoilApi
@Composable
fun <T: Item>ItemBottomPreview(item: T?, onGoToDetail: (Int) -> Unit) {

    if (item != null){
        Row(modifier = Modifier.padding(18.dp),horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(
                painter = rememberImagePainter(item.image),
                contentDescription = null,
                modifier = Modifier
                    .width(90.dp)
                    .aspectRatio(1 / 1f)
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.h6)
                Text(
                    fontSize = 32.sp,
                    text = item.restaurantChain,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    color = Yelow700Demi
                )
                Button(
                    onClick = { onGoToDetail(item.id)},
                    modifier = Modifier.align(Alignment.End)
                ){
                    Text(text = stringResource(id = R.string.go_to_detail))
                }
            }
        }
    }else{
        Spacer(modifier = Modifier.height(1.dp))
    }

}
