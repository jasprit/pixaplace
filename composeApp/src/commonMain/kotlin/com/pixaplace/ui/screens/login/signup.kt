package com.pixaplace.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.PrimaryButton
import com.pixaplace.ui.screens.login.AuthViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SignupScreen(
    viewModel: AuthViewModel, onLoginClick: () -> Unit, onSuccess: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Create Account", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(32.dp))

            AppTextField(value = name, onValueChange = { password = it }, label = "Full Name")

            Spacer(Modifier.height(12.dp))

            AppTextField(value = email, onValueChange = { email = it }, label = "Email")

            Spacer(Modifier.height(12.dp))

            AppTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isPassword = true
            )

            Spacer(Modifier.height(24.dp))

            PrimaryButton("Sign Up", enabled = !state.loading, loading = state.loading) {
                onSuccess()
            }

            Spacer(Modifier.height(16.dp))

            TextButton(onClick = onLoginClick) {
                Text("Already have an account? Log in")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    val viewModel = AuthViewModel()
    SignupScreen(onLoginClick = {}, onSuccess = {}, viewModel = viewModel)
}