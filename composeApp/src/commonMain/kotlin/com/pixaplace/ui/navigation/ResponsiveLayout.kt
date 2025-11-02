package com.pixaplace.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pixaplace.platform.isMobile
import com.pixaplace.platform.isTablet
import com.pixaplace.ui.components.BottomNavigationBar
import com.pixaplace.ui.screens.login.AuthViewModel

@Composable
fun ResponsiveLayout(
    navController: NavHostController,
    bottomBarItems: List<NavItem> = emptyList(),
    sidebarItems: List<NavItem> = emptyList(),
    authViewModel: AuthViewModel,
    content: @Composable () -> Unit,
) {
    val mobile = isMobile()
    val tablet = isTablet()

    when {
        mobile -> {
            Scaffold(
                bottomBar = {
                    if (bottomBarItems.isNotEmpty()) {
                        BottomNavigationBar(navController, bottomBarItems)
                    }
                }) { innerPadding ->
                Box(Modifier.padding(innerPadding)) { content() }
            }
        }

        tablet -> {
            Row {
                if (sidebarItems.isNotEmpty()) {
                    SidebarMenu(
                        navController, sidebarItems, width = 180.dp,
                        onLogout = {},
                    )
                }
                Box(modifier = Modifier.weight(1f)) { content() }
            }
        }

        else -> {
            // Web/Desktop
            Row {
                if (sidebarItems.isNotEmpty()) {
                    SidebarMenu(navController, sidebarItems, width = 250.dp, onLogout = {
                        authViewModel.logout()
                        navController.navigate(NavItem.Login.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            } // remove login from back stack
                            launchSingleTop = true // prevent multiple copies of the same destination
                        }

                    })
                }
                Box(modifier = Modifier.weight(1f)) { content() }
            }
        }
    }
}