package com.pixaplace.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixaplace.storage.AuthRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class AuthUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
    val token: String? = null,
)

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun onEmailChange(value: String) = update { it.copy(email = value, error = null) }
    fun onPasswordChange(value: String) = update { it.copy(password = value, error = null) }
    fun onNameChanged(value: String) = update { it.copy(name = value, error = null) }

    init {
        // Check if user is already logged in
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                success = authRepository.isLoggedIn(),
                token = authRepository.getToken()
            )
        }
    }

    fun login() {
        val state = _uiState.value

        // Validate email
        validateEmail(state.email)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        // Validate password
        validatePassword(state.password)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        // clear any existing error and start loading
        update { it.copy(loading = true, error = null) }
        scope.launch {
            // Save token using repository
            authRepository.saveToken(state.password) // example: save password as token

            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    fun signup() {
        val state = _uiState.value

        // Validate name
        validateName(state.name)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        // Validate email
        validateEmail(state.email)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        // Validate password
        validatePassword(state.password)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        // clear any existing error and start loading
        update { it.copy(loading = true, error = null) }
        scope.launch {
            // Save token after signup
            authRepository.saveToken(state.password) // example

            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    fun forgotPassword() {
        val state = _uiState.value

        // Validate email
        validateEmail(state.email)?.let { errorMsg ->
            update { it.copy(error = errorMsg) }
            return
        }

        update { it.copy(loading = true, error = null) }
        scope.launch {
            delay(700)
            update { it.copy(loading = false, success = true) }
        }
    }

    // --- Logout ---
    fun logout() {
        scope.launch {
            authRepository.removeToken()
            update { it.copy(success = false, token = null) }
        }
    }

    private fun update(block: (AuthUiState) -> AuthUiState) {
        _uiState.value = block(_uiState.value)
    }

    private fun validateName(name: String, minLength: Int = 2, maxLength: Int = 50): String? =
        when {
            name.isBlank() -> "Name cannot be blank"
            !name.matches(Regex("^[A-Za-z ]+$")) -> "Name can only contain letters"
            name.length < minLength -> "Name must be at least $minLength characters"
            name.length > maxLength -> "Name cannot exceed $maxLength characters"
            else -> null
        }

    private fun validatePassword(password: String, minLength: Int = 6, maxLength: Int = 20): String? =
        when {
            password.isBlank() -> "Password cannot be blank"
            password.length < minLength -> "Password must be at least $minLength characters"
            password.length > maxLength -> "Password cannot exceed $maxLength characters"
            else -> null
        }

    private fun validateEmail(email: String, maxLength: Int = 50): String? =
        when {
            email.isBlank() -> "Email cannot be blank"
            email.length > maxLength -> "Email cannot exceed $maxLength characters"
            !Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matches(email) -> "Invalid email"
            else -> null
        }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}
