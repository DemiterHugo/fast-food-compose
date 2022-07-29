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
import com.example.recipes.ui.screens.detailpizza.DetailPizzaScreen
import com.example.recipes.ui.screens.pizzas.PizzasScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable(route = "main"){
            PizzasScreen(onClicked = { navController.navigate("detailPizza/$it")})
        }
        composable(
            route = "detailPizza/{pizzaId}",
            arguments = listOf(navArgument(name = "pizzaId"){type = NavType.IntType})
        ){
            val id = it.arguments?.getInt("pizzaId")
            requireNotNull(id)
            DetailPizzaScreen(id)
        }
    }
}