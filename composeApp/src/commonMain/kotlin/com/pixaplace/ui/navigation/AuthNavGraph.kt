package com.pixaplace.presentation.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pixaplace.ui.navigation.NavItem
import com.pixaplace.ui.screens.login.AuthViewModel
import com.pixaplace.ui.screens.login.LoginScreen

@Composable
fun AuthNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {

    NavHost(
        navController = navController, startDestination = NavItem.Login.route
    ) {
        composable(NavItem.Login.route) {
            LoginScreen(
                onSignupClick = { navController.navigate(NavItem.SignUp.route) },
                onForgotClick = { navController.navigate(NavItem.ForgotPassword.route) },
                vm = authViewModel,
                onSuccess = {
                    navController.navigate(NavItem.Home.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        } // remove login from back stack
                        launchSingleTop = true // prevent multiple copies of the same destination
                    }
                })
        }

        composable(NavItem.SignUp.route) {
            SignupScreen(
                onLoginClick = { navController.popBackStack() },
                onSuccess = { navController.navigate(NavItem.Home.route) },
                viewModel = authViewModel
            )
        }

        composable(NavItem.ForgotPassword.route) {
            ForgotPasswordScreen(
                onBackToLogin = { navController.popBackStack() },
                onResetSent = { navController.popBackStack() })
        }
    }
}
