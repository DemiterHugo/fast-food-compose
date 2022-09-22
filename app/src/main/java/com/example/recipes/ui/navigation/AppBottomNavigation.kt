package com.example.recipes.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun AppBottomNavigation(
    bottomNavOptions: List<NavItem>,
    currentRoute: String,
    onNavItemClick: (NavItem) -> Unit
) {
    BottomNavigation {
        bottomNavOptions.forEach {
            val title = stringResource(id = it.title)
            BottomNavigationItem(
                selected = currentRoute.contains(it.navCommand.typeMenu.routeType),
                onClick = {
                    //navController.navigatePoppingUpToStartDestination(it.navCommand.route)
                          onNavItemClick(it)
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = title
                    )
                },
                label = { Text(text = title)}
            )
        }
    }
}