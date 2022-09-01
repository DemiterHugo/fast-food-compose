package com.example.recipes.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgs
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.navigation.NavItem.Detail
import com.example.recipes.ui.navigation.NavItem.Main
import com.example.recipes.ui.screens.detailpizza.DetailPizzaScreen
import com.example.recipes.ui.screens.pizzas.PizzasScreen

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Main.route) {
        composable(route = Main.route) {
            PizzasScreen(onClicked2 = { navController.navigate(Detail.putIdInDetail(it)) })      //"detailPizza/$it"
        }
        composable(
            route = Detail.route,                //route = "detailPizza/{pizzaId}"
            arguments = Detail.arguments
        ) {
            val id = it.arguments?.getInt(NArgs.PizzaId.key)
            requireNotNull(id)
            DetailPizzaScreen(id) { navController.popBackStack() }
        }
    }
}

    private fun NavGraphBuilder.fillComposable(navItem: NavItem, content: @Composable (NavBackStackEntry) -> Unit){
        composable(route = navItem.route, arguments = navItem.arguments){
            content(it)
        }
    }

    private inline fun <reified T> NavBackStackEntry.findArg(nArgs: NArgs): T {
        val value = arguments?.get(nArgs.key)
        requireNotNull(value)
        return value as T
    }
