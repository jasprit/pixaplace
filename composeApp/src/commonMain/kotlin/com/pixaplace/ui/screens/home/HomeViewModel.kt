package com.pixaplace.ui.screens.home

import androidx.lifecycle.ViewModel
import com.pixaplace.platform.AuthRepository
import kotlinx.coroutines.*


class HomeViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun logout() {
        scope.launch {
            authRepository.removeToken()
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}