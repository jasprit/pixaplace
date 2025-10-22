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

    if (state.success) {
        LaunchedEffect(Unit) {
            onSuccess()
        }
    }

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

            AppTextField(value = state.name, onValueChange = viewModel::onNameChanged, label = "Full Name")

            Spacer(Modifier.height(12.dp))

            AppTextField(value = state.email, onValueChange = viewModel::onEmailChange, label = "Email")

            Spacer(Modifier.height(12.dp))

            AppTextField(value = state.password, onValueChange = viewModel::onPasswordChange, label = "Password", isPassword = true)

            Spacer(Modifier.height(24.dp))

            if (state.error != null) {
                Text(state.error!!, color = MaterialTheme.colorScheme.error)
                Spacer(Modifier.height(8.dp))
            }

            PrimaryButton("Sign Up", enabled = !state.loading, loading = state.loading) {
               viewModel.signup()
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