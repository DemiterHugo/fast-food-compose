package com.example.recipes.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NArgs> = emptyList()
){
    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute).plus(argKeys).joinToString("/")
    }

    val arguments = navArgs.map {
        navArgument(name = it.key){type = it.navTipe}
    }

    object Main: NavItem(baseRoute = "main")        //son dos objetos xq no reciben argumentos
    object Detail: NavItem(baseRoute = "detailPizza", navArgs = listOf(NArgs.PizzaId)){
        fun putIdInDetail(id: Int): String{
            return "$baseRoute/$id"
        }
    }
}

//se pone * xq se trata de cualquier tipo (ej NavType.IntType) que soporte Navtype
enum class NArgs(val key: String, val navTipe: NavType<*>){
    PizzaId(key = "pizzaId", navTipe = NavType.IntType)
}