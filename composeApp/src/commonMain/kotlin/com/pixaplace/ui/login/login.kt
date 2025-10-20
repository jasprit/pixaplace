package com.pixaplace.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pixaplace.ui.components.AppTextField
import com.pixaplace.ui.components.PrimaryButton
import org.jetbrains.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(
    vm: AuthViewModel,
    onSignupClick: () -> Unit,
    onForgotClick: () -> Unit,
    onSuccess: () -> Unit
) {
    val state by vm.uiState.collectAsState()

    if (state.success) onSuccess()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.widthIn(max = 360.dp).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome back", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(16.dp))

            AppTextField(state.email, vm::onEmailChange, "Email")
            Spacer(Modifier.height(8.dp))
            AppTextField(state.password, vm::onPasswordChange, "Password", isPassword = true)
            Spacer(Modifier.height(16.dp))

            if (state.error != null) {
                Text(state.error!!, color = MaterialTheme.colorScheme.error)
                Spacer(Modifier.height(8.dp))
            }

            PrimaryButton("Log in", enabled = !state.loading, loading = state.loading) {
                vm.login()
            }

            Spacer(Modifier.height(12.dp))
            TextButton(onClick = onForgotClick) { Text("Forgot password?") }
            Spacer(Modifier.height(4.dp))
            TextButton(onClick = onSignupClick) { Text("Don’t have an account? Sign up") }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreView() {
    // Dummy ViewModel for preview
    val vm = remember { AuthViewModel() }

    LoginScreen(
        vm = vm,
        onSignupClick = {},
        onForgotClick = {},
        onSuccess = {}
    )

}
