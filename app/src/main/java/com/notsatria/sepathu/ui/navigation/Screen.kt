package com.notsatria.sepathu.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Cart : Screen("cart")
    data object Profile : Screen("profile")
    data object Search : Screen("search")
    data object DetailShoe : Screen("home/{shoeId}") {
        fun createRoute(shoeId: Int) = "home/$shoeId"
    }
}