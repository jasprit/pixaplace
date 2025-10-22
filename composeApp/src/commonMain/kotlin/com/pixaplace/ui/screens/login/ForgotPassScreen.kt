package com.pixaplace.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ForgotPasswordScreen(
    onBackToLogin: () -> Unit, onResetSent: () -> Unit
) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.widthIn(max = 360.dp).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Reset Password", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(24.dp))

            Button(
                onClick = { onResetSent() }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Send Reset Link")
            }

            Spacer(Modifier.height(16.dp))
            TextButton(onClick = onBackToLogin) {
                Text("Back to Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(onBackToLogin = {}, onResetSent = {})
}