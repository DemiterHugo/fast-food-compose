package com.example.recipes.ui.navigation

import androidx.annotation.NavigationRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.ui.navigation.NavItem.*
import com.example.recipes.ui.screens.detailpizza.DetailPizzaScreen
import com.example.recipes.ui.screens.pizzas.PizzasScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Main.route){
        composable(route = Main.route){
            PizzasScreen(onClicked = { navController.navigate(Detail.putIdInDetail(it))})      //"detailPizza/$it"
        }
        composable(
            route = Detail.route,                //route = "detailPizza/{pizzaId}"
            arguments = Detail.arguments
        ){
            val id = it.arguments?.getInt(NArgs.PizzaId.key)
            requireNotNull(id)
            DetailPizzaScreen(id)
        }
    }
}