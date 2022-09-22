package com.example.recipes.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.recipes.R


enum class NavItem(val navCommand: NavCommand, val icon: ImageVector, @StringRes val title: Int){
    PIZZAS(NavCommand.ContentType(TypeOfMenu.PIZZA), Icons.Default.Face, R.string.pizzas),
    BURGERS(NavCommand.ContentType(TypeOfMenu.BURGER), Icons.Default.Book, R.string.burgers),
    SUSHIS(NavCommand.ContentType(TypeOfMenu.SUSHI), Icons.Default.Event, R.string.sushis),
    APPLES(NavCommand.ContentType(TypeOfMenu.APPLE), Icons.Default.AccessTime, R.string.apples),

    USERS(NavCommand.ContentType(TypeOfMenu.USER), Icons.Default.VerifiedUser, R.string.users),
    HOME(NavCommand.ContentType(TypeOfMenu.PIZZA), Icons.Default.Home, R.string.home),
    SETTINGS(NavCommand.ContentType(TypeOfMenu.SETTING),Icons.Default.Settings, R.string.settings)
}

sealed class NavCommand(
    internal val typeMenu: TypeOfMenu,
    val subroute: String = "home",
    val navArgs: List<NArgs> = emptyList()
){
    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(typeMenu.routeType).plus(subroute).plus(argKeys).joinToString("/")
    }

    val arguments = navArgs.map {
        navArgument(name = it.key){type = it.navType}
    }

    class ContentType(menu: TypeOfMenu): NavCommand(typeMenu = menu)
    class ContentDetail(menu: TypeOfMenu): NavCommand(menu, "detail", listOf(NArgs.ItemId)){
        fun putIdInDetail(itemId: Int) = "${typeMenu.routeType}/$subroute/$itemId"
    }
}

//se pone * xq se trata de cualquier tipo (ej NavType.IntType) que soporte Navtype
enum class NArgs(val key: String, val navType: NavType<*>){
    ItemId(key = "itemId", navType = NavType.IntType),

}