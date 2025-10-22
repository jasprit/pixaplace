package com.pixaplace.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pixaplace.ui.screens.home.Home
import com.pixaplace.ui.screens.login.AuthViewModel
import com.pixaplace.ui.screens.login.LoginScreen

@Composable
fun AuthNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            val vm = remember { AuthViewModel() }
            LoginScreen(
                onSignupClick = { navController.navigate("signup") },
                onForgotClick = { navController.navigate("forgot") },
                vm = vm,
                onSuccess = { navController.navigate("signup") }
            )
        }

        composable("signup") {
            val viewModel = remember { AuthViewModel() }
            SignupScreen(
                onLoginClick = { navController.popBackStack() },
                onSuccess = { navController.navigate("home") },
                viewModel = viewModel
            )
        }

        composable("forgot") {
            ForgotPasswordScreen(
                onBackToLogin = { navController.popBackStack() },
                onResetSent = { navController.popBackStack() }
            )
        }

        composable("home") {
            Home()
        }
    }
}
