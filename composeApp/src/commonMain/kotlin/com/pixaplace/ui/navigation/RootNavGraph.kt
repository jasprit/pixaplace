package com.pixaplace.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.pixaplace.presentation.auth.AuthNavGraph
import com.pixaplace.presentation.auth.MainNavGraph
import com.pixaplace.ui.components.BottomNavigationBar
import com.pixaplace.ui.screens.login.AuthViewModel

@Composable
fun RootNavGraph() {
    // Single NavController for the whole root graph
    val rootController = rememberNavController()

    // Single AuthViewModel instance
    val authViewModel = remember { AuthViewModel() }
    val uiState by authViewModel.uiState.collectAsState()

    if (uiState.success) { // success = logged in
        ResponsiveLayout(
            navController = rootController,
            bottomBarItems = listOf(NavItem.Home, NavItem.Search, NavItem.Account),
            sidebarItems = listOf(NavItem.Home, NavItem.Search, NavItem.Account)
        ) {
            MainNavGraph(rootController)
        }
    } else {
        AuthNavGraph(
            navController = rootController, authViewModel = authViewModel
        )
    }
}