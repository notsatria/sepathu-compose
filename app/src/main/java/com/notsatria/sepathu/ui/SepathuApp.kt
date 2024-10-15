package com.notsatria.sepathu.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notsatria.sepathu.MainViewModel
import com.notsatria.sepathu.ui.cart.CartScreen
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
    
    Scaffold(
        containerColor = DarkNavy,
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Cart.route) {
                CartScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}