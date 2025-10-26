package com.pixaplace.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.PrimaryButton
import com.pixaplace.ui.components.TertiaryButton
import com.pixaplace.ui.screens.login.AuthViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SignupScreen(
    viewModel: AuthViewModel,
    onLoginClick: () -> Unit,
    onSuccess: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    // Navigate on success
    if (state.success) {
        LaunchedEffect(Unit) {
            onSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // CHANGED: Theme background
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
                text = "Create Account",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(32.dp))

            // Name Field
            AppTextField(
                value = state.name,
                onValueChange = viewModel::onNameChanged,
                label = "Full Name",
                keyboardType = KeyboardType.Text
            )

            Spacer(Modifier.height(12.dp))

            // Email Field
            AppTextField(
                value = state.email,
                onValueChange = viewModel::onEmailChange,
                label = "Email",
                keyboardType = KeyboardType.Email
            )

            Spacer(Modifier.height(12.dp))

            // Password Field
            AppTextField(
                value = state.password,
                onValueChange = viewModel::onPasswordChange,
                label = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password
            )

            // Error Message
            if (state.error != null) {
                Spacer(Modifier.height(16.dp))
                Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(Modifier.height(24.dp))

            // Sign Up Button
            PrimaryButton("Sign Up", enabled = !state.loading, loading = state.loading) {
                viewModel.signup()
            }

            Spacer(Modifier.height(16.dp))

            // Login Link
            TertiaryButton(
                "Already have an account? Log in",
                onClick = onLoginClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
//    val viewModel = AuthViewModel()
//    SignupScreen(onLoginClick = {}, onSuccess = {}, viewModel = viewModel)
}