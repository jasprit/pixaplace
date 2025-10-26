package com.pixaplace.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.PrimaryButton
import com.pixaplace.ui.components.TertiaryButton
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ForgotPasswordScreen(
    onBackToLogin: () -> Unit,
    onResetSent: () -> Unit
) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Theme background
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 360.dp)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Title
            Text(
                text = "Reset Password",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary // #DB94AC — brand emphasis
            )

            Spacer(Modifier.height(32.dp))

            // Email Field — using AppTextField
            AppTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                keyboardType = KeyboardType.Email
            )

            Spacer(Modifier.height(24.dp))

            // Send Button
            PrimaryButton(
                text = "Send",
                onClick = onResetSent
            )

            Spacer(Modifier.height(16.dp))

            // Back to Login
            TertiaryButton(
                text = "Back to Login",
                onClick = onBackToLogin
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(onBackToLogin = {}, onResetSent = {})
}