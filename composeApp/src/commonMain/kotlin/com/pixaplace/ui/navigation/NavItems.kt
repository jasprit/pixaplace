package com.pixaplace.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


// --- NavItem.kt ---
sealed class NavItem(val route: String, val label: String, val icon: ImageVector?) {

    // Splash and Onboarding
    data object Splash : NavItem("splash", "Splash", null)
    data object Onboarding : NavItem("onboarding", "Onboarding", null)

    // Auth routes
    data object Login : NavItem("login", "Login", null)
    data object SignUp : NavItem("signUp", "Sign Up", null)
    data object ForgotPassword : NavItem("forgotPassword", "Forgot Password", null)

    // Main routes
    data object Home : NavItem("home", "Home", Icons.Default.Home)
    data object Search : NavItem("search", "Search", Icons.Default.Search)
    data object Account : NavItem("account", "Account", Icons.Default.Person)
}