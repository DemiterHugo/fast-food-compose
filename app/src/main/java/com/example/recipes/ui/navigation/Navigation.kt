package com.example.recipes.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.screens.apples.ApplesScreen
import com.example.recipes.ui.screens.burgers.BurgerDetailScreen
import com.example.recipes.ui.screens.burgers.BurgersScreen
import com.example.recipes.ui.screens.pizzas.PizzaDetailScreen
import com.example.recipes.ui.screens.pizzas.PizzasScreen
import com.example.recipes.ui.screens.sushis.SushiDetailScreen
import com.example.recipes.ui.screens.sushis.SushisScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = TypeOfMenu.PIZZA.routeType
    ) {
        PizzasNav(navController)
        BurgersNav(navController)
        SushisNav(navController)
        fillComposable(NavCommand.ContentType(TypeOfMenu.APPLE)){
            ApplesScreen()
        }
        fillComposable(NavCommand.ContentType(TypeOfMenu.SETTING)){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Settings ", style = MaterialTheme.typography.h3)
            }
        }
        fillComposable(NavCommand.ContentType(TypeOfMenu.USER)){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "User ", style = MaterialTheme.typography.h3)
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.PizzasNav(navController: NavController){

    navigation(
        startDestination = NavCommand.ContentType(TypeOfMenu.PIZZA).route,
        route = TypeOfMenu.PIZZA.routeType
    ){
        fillComposable(NavCommand.ContentType(TypeOfMenu.PIZZA)){
            PizzasScreen(onClicked2 = {
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.PIZZA).putIdInDetail(it))
            })
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.PIZZA)){
            PizzaDetailScreen() //{ navController.popBackStack() }

        }
    }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.BurgersNav(navController: NavController){

    navigation(
        startDestination = NavCommand.ContentType(TypeOfMenu.BURGER).route,
        route = TypeOfMenu.BURGER.routeType
    ){
        fillComposable(NavCommand.ContentType(TypeOfMenu.BURGER)){
            BurgersScreen(onClicked2 = {
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.BURGER).putIdInDetail(it))
            })
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.BURGER)){
            BurgerDetailScreen()
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.SushisNav(navController: NavController){

    navigation(
        startDestination = NavCommand.ContentType(TypeOfMenu.SUSHI).route,
        route = TypeOfMenu.SUSHI.routeType
    ){
        fillComposable(NavCommand.ContentType(TypeOfMenu.SUSHI)){
            SushisScreen(onClicked2 = {
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.SUSHI).putIdInDetail(it))
            })
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.SUSHI)){
            SushiDetailScreen()
        }
    }
}


    private fun NavGraphBuilder.fillComposable(navCommand: NavCommand, content: @Composable (NavBackStackEntry) -> Unit){
        composable(route = navCommand.route, arguments = navCommand.arguments){
            content(it)
        }
    }

    private inline fun <reified T> NavBackStackEntry.findArg(nArgs: NArgs): T {
        val value = arguments?.get(nArgs.key)
        requireNotNull(value)
        return value as T
    }
