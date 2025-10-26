package com.pixaplace.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pixaplace.ui.components.AppTextField
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.PrimaryButton
import com.pixaplace.ui.components.SecondaryButton
import com.pixaplace.ui.components.TertiaryButton


@Composable
fun LoginScreen(
    vm: AuthViewModel,
    onSignupClick: () -> Unit,
    onForgotClick: () -> Unit,
    onSuccess: () -> Unit
) {
    val state by vm.uiState.collectAsState()

    if (state.success) {
        LaunchedEffect(state.success) {
            onSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.widthIn(max = 360.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Title
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(24.dp))

            // Email & Password Fields
            AppTextField(
                value = state.email,
                onValueChange = vm::onEmailChange,
                label = "Email",
                keyboardType = KeyboardType.Email
            )
            Spacer(Modifier.height(12.dp))

            AppTextField(
                value = state.password,
                onValueChange = vm::onPasswordChange,
                label = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password
            )

            // Error Message
            if (state.error != null) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(24.dp))

            PrimaryButton("Log in", enabled = !state.loading, loading = state.loading) {
                vm.login()
            }

            Spacer(Modifier.height(16.dp))

            // Secondary Actions
            SecondaryButton(
                "Forgot password?",
                onClick = onForgotClick
            )

            TertiaryButton(
                "Don’t have an account? Sign up",
                onClick = onSignupClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreView() {
    // Dummy ViewModel for preview
//    val viewModel = remember { AuthViewModel() }
//
//    LoginScreen(vm = viewModel, onSignupClick = {}, onForgotClick = {}, onSuccess = {})
}
