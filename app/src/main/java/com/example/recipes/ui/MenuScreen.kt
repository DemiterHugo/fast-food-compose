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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.R
import com.example.recipes.ui.navigation.*
import com.example.recipes.ui.screens.detailpizza.AppBarIcon
import com.example.recipes.ui.theme.RecipesTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun FoodApp(){
    val navController = rememberNavController()
    val navBackStackEntry by  navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route?: ""
    val showUpNavitagion = currentRoute !in NavItem.values().map {
        it.navCommand.route
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val drawerOptions = listOf(NavItem.HOME,NavItem.SETTINGS, NavItem.USERS)
    val bottomNavOptions = listOf(NavItem.PIZZAS, NavItem.BURGERS, NavItem.SUSHIS, NavItem.APPLES)
    
    FoodScreen{
        Scaffold(
            topBar = {
                     TopAppBar(

                         title = {
                             if(!showUpNavitagion){
                                 Text(text = stringResource(id = R.string.app_name))
                             }},
                         navigationIcon ={
                             if (showUpNavitagion){
                                     AppBarIcon(
                                         imageVector = Icons.Default.ArrowBack
                                     ) { navController.popBackStack() }
                             }else{
                                 AppBarIcon(
                                     imageVector = Icons.Default.Menu,
                                     onClickIcon = {scope.launch {scaffoldState.drawerState.open()}}
                                 )
                             }
                         }
                     )
            },
            bottomBar = {
                AppBottomNavigation(bottomNavOptions = bottomNavOptions, currentRoute = currentRoute) {
                    navController.navigatePoppingUpToStartDestination(it.navCommand.route)
                }
            },
            drawerContent = {
                DrawerContent(
                    drawerOptions = drawerOptions,
                    onOptionClick = {
                        navController.navigate(it.navCommand.route)
                        scope.launch { scaffoldState.drawerState.close()}
                    },
                    currentRoute = currentRoute
                ) },
            scaffoldState = scaffoldState
        ) {
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