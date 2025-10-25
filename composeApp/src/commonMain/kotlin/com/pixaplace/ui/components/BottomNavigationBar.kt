package com.pixaplace.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pixaplace.ui.navigation.NavItem

@Composable
fun BottomNavigationBar(
    navController: NavHostController, items: List<NavItem>
) {
    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        items.forEach { item ->
            val selected = currentDestination?.route == item.route
            NavigationBarItem(icon = {
                item.icon?.let {
                    Icon(
                        imageVector = it, contentDescription = item.label
                    )
                }
            }, label = { Text(item.label) }, selected = selected, onClick = {
                navController.navigate(item.route) {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
    }
}