package com.example.recipes.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.navigation.AppBottomNavigation
import com.example.recipes.ui.navigation.NavItem
import com.example.recipes.ui.navigation.Navigation
import com.example.recipes.ui.navigation.navigatePoppingUpToStartDestination
import com.example.recipes.ui.theme.RecipesTheme
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun FoodApp(){
    val navController = rememberNavController()
    val navBackStackEntry by  navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route?: ""
    
    FoodScreen{
        Scaffold(
            bottomBar = {
                AppBottomNavigation(currentRoute = currentRoute, onNavItemClick = {
                    navController.navigatePoppingUpToStartDestination(it.navCommand.route)
                })
            } ) {
            Box(modifier = Modifier.padding(it)){
                Navigation(navController)
            }
        }
    }
}



@Composable
fun FoodScreen(content: @Composable ()-> Unit) {
    RecipesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}