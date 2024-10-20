package com.notsatria.sepathu.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.notsatria.sepathu.MainViewModel
import com.notsatria.sepathu.ui.cart.CartScreen
import com.notsatria.sepathu.ui.detail.DetailScreen
import com.notsatria.sepathu.ui.home.HomeScreen
import com.notsatria.sepathu.ui.navigation.BottomNavigationBar
import com.notsatria.sepathu.ui.navigation.Screen
import com.notsatria.sepathu.ui.profile.ProfileScreen
import com.notsatria.sepathu.ui.theme.DarkNavy
import org.koin.androidx.compose.koinViewModel

@Composable
fun SepathuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        mainViewModel.populateShoesData()
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        containerColor = DarkNavy,
        bottomBar = {
            if (currentRoute != Screen.DetailShoe.route)
                BottomNavigationBar(navController = navController, currentRoute = currentRoute)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { shoeId ->
                    navController.navigate(Screen.DetailShoe.createRoute(shoeId))
                })
            }
            composable(Screen.Cart.route) {
                CartScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailShoe.route, arguments = listOf(navArgument("shoeId") {
                    type = NavType.IntType
                })
            ) {
                val id = it.arguments?.getInt("shoeId") ?: -1
                DetailScreen(
                    shoeId = id,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}