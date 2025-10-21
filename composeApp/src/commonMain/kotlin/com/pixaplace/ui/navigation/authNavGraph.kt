package com.pixaplace.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pixaplace.ui.login.AuthViewModel
import com.pixaplace.ui.login.LoginScreen

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
                onSuccess = {navController.navigate("signup")}
            )
        }

        composable("signup") {
            SignupScreen(
                onLoginClick = { navController.popBackStack() },
                onSuccess = { /* TODO: Go to home later */ }
            )
        }

        composable("forgot") {
            ForgotPasswordScreen(
                onBackToLogin = { navController.popBackStack() },
                onResetSent = { navController.popBackStack() }
            )
        }
    }
}
