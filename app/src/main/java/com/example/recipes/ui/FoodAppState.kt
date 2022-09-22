package com.example.recipes.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipes.ui.navigation.NavItem
import com.example.recipes.ui.navigation.navigatePoppingUpToStartDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//extraer el estado y logia de UI
@Composable
fun rememberFoodAppState(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope()
): FoodAppState = remember(navController, scaffoldState, scope) {
    FoodAppState(navController, scaffoldState, scope)
}


class FoodAppState(val navController: NavHostController, val scaffoldState: ScaffoldState, val scope: CoroutineScope) {

    companion object{
        val DRAWER_OPTIONS = listOf(NavItem.HOME,NavItem.SETTINGS, NavItem.USERS)
        val BOTTOM_NAV_OPTIONS = listOf(NavItem.PIZZAS, NavItem.BURGERS, NavItem.SUSHIS, NavItem.APPLES)
    }

    val currentRoute: String
    @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route?: ""

    val showUpNavitagion: Boolean
    @Composable get()= currentRoute !in NavItem.values().map {
        it.navCommand.route
    }

    fun onUpClick() {
        navController.popBackStack()
    }

    fun onMenuClick() {
        scope.launch {scaffoldState.drawerState.open()}
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }

    fun onDrawerOptionClick(navItem: NavItem) {
        scope.launch { scaffoldState.drawerState.close()}
        //navController.navigate(navItem.navCommand.route)
        onNavItemClick(navItem)
    }
}
