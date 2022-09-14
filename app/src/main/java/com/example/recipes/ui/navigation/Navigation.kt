package com.example.recipes.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
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
            PizzasScreen(){
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.PIZZA).putIdInDetail(it))
            }
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.PIZZA)){
            val pizzaId = it.findArg<Int>(NArgs.ItemId)
            PizzaDetailScreen(pizzaId = pizzaId) { navController.popBackStack() }

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
            BurgersScreen(){
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.BURGER).putIdInDetail(it))
            }
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.BURGER)){
            val burgerId = it.findArg<Int>(NArgs.ItemId)
            BurgerDetailScreen(burgerId = burgerId) { navController.popBackStack() }
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
            SushisScreen(){
                navController.navigate(NavCommand.ContentDetail(TypeOfMenu.SUSHI).putIdInDetail(it))
            }
        }
        fillComposable(NavCommand.ContentDetail(TypeOfMenu.SUSHI)){
            val sushiId = it.findArg<Int>(NArgs.ItemId)
            SushiDetailScreen(sushiId = sushiId) { navController.popBackStack() }
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
