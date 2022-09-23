package com.example.recipes.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.R
import com.example.recipes.ui.navigation.AppBottomNavigation
import com.example.recipes.ui.navigation.DrawerContent
import com.example.recipes.ui.navigation.Navigation
import com.example.recipes.ui.screens.common.AppBarIcon
import com.example.recipes.ui.theme.RecipesTheme
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun FoodApp(){
    val appState = rememberFoodAppState()



    
    FoodScreen{
        Scaffold(
            topBar = {
                     TopAppBar(
                         title = { Text(text = stringResource(id = R.string.app_name)) },
                         navigationIcon ={
                             if (appState.showUpNavitagion){
                                     AppBarIcon(
                                         imageVector = Icons.Default.ArrowBack,
                                         onClickIcon = { appState.onUpClick()}
                                     )
                             }else{
                                 AppBarIcon(
                                     imageVector = Icons.Default.Menu,
                                     onClickIcon = {appState.onMenuClick()}
                                 )
                             }
                         }
                     )
            },
            bottomBar = {
                AppBottomNavigation(
                    bottomNavOptions = FoodAppState.BOTTOM_NAV_OPTIONS,
                    currentRoute = appState.currentRoute,
                    onNavItemClick = { appState.onNavItemClick(it) }
                )
            },
            drawerContent = {
                DrawerContent(
                    drawerOptions = FoodAppState.DRAWER_OPTIONS,
                    onOptionClick = { appState.onDrawerOptionClick(it) },
                    currentRoute = appState.currentRoute
                ) },
            scaffoldState = appState.scaffoldState
        ) {
            Box(modifier = Modifier.padding(it)){
                Navigation(appState.navController)
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