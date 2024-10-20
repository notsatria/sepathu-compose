package com.notsatria.sepathu.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.notsatria.sepathu.ui.theme.DarkGrey
import com.notsatria.sepathu.ui.theme.Purple
import com.notsatria.sepathu.ui.theme.SoftBlack
import com.notsatria.sepathu.ui.theme.SoftPurple

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    currentRoute: String? = null
) {
    NavigationBar(modifier, containerColor = SoftBlack) {
        val navItems = listOf(
            NavigationItem("Home", Icons.Default.Home, Screen.Home),
            NavigationItem("Cart", Icons.Default.ShoppingCart, Screen.Cart),
            NavigationItem("Profile", Icons.Default.AccountCircle, Screen.Profile),
        )
        navItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label, tint = DarkGrey) },
                label = { Text(text = item.label) },
                colors = NavigationBarItemColors(
                    selectedIconColor = Purple,
                    selectedTextColor = Purple,
                    selectedIndicatorColor = SoftPurple,
                    unselectedIconColor = DarkGrey,
                    unselectedTextColor = DarkGrey,
                    disabledIconColor = SoftBlack,
                    disabledTextColor = SoftBlack,
                )
            )
        }
    }
}