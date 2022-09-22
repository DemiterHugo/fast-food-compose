package com.example.recipes.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.recipes.R


@Composable
fun DrawerContent(drawerOptions: List<NavItem>, onOptionClick: (NavItem) -> Unit, currentRoute: String){
    Column() {
           Image(
               painter = painterResource(id = R.drawable.user2),
               contentDescription = null,
               modifier = Modifier.fillMaxWidth().padding(5.dp),
               contentScale = ContentScale.FillWidth,

           )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(15.dp))
            drawerOptions.forEach{  navItem ->
                val selected = currentRoute == navItem.navCommand.route
                Row(modifier = Modifier
                    .clickable { onOptionClick(navItem) }
                    .fillMaxWidth()
                    .padding(8.dp,4.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f) else MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(id = navItem.title),
                        tint = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = stringResource(id = navItem.title),
                        color = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
    }
}
