package com.pixaplace.presentation.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pixaplace.ui.navigation.NavItem
import com.pixaplace.ui.screens.main.Account
import com.pixaplace.ui.screens.main.Home
import com.pixaplace.ui.screens.main.Search

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = NavItem.Home.route
    ) {

        composable(NavItem.Home.route) {
            Home()
        }

        composable(NavItem.Search.route) {
            Search()
        }

        composable(NavItem.Account.route) {
            Account()
        }
    }
}