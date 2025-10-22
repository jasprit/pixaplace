package com.pixaplace.ui.screens.login

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

class AuthViewModel {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    private val scope = CoroutineScope(Dispatchers.Main)

    fun onEmailChange(value: String) = update { it.copy(email = value, error = null) }
    fun onPasswordChange(value: String) = update { it.copy(password = value, error = null) }
    fun onRepeatPasswordChange(value: String) = update { it.copy(repeatPassword = value, error = null) }

    fun login() {
        val state = _uiState.value
        if (state.email.isBlank() || state.password.length < 6) {
            update { it.copy(error = "Invalid credentials") }
            return
        }
        update { it.copy(loading = true, error = null) }
        scope.launch {
            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    fun signup() {
        val state = _uiState.value
        if (state.password != state.repeatPassword) {
            update { it.copy(error = "Passwords do not match") }
            return
        }
        update { it.copy(loading = true, error = null) }
        scope.launch {
            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    fun forgotPassword() {
        val state = _uiState.value
        if (state.email.isBlank()) {
            update { it.copy(error = "Enter your email") }
            return
        }
        update { it.copy(loading = true, error = null) }
        scope.launch {
            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    private fun update(block: (AuthUiState) -> AuthUiState) {
        _uiState.value = block(_uiState.value)
    }
}
