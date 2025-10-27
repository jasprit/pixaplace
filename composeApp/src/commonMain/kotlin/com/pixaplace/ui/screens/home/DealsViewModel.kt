package com.pixaplace.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.Deal
import data.model.sampleDeals
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class DealsUiState(
    val deals: List<Deal> = emptyList(),
    val featuredDeal: Deal? = null,
    val searchQuery: String = "",
    val selectedCategory: String = "All",
    val isRefreshing: Boolean = false,
    val isLoadingMore: Boolean = false
)

class DealsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DealsUiState())
    val uiState: StateFlow<DealsUiState> = _uiState

    init {
        loadDeals()
    }

    fun loadDeals() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                deals = sampleDeals,
                featuredDeal = sampleDeals.find { it.isFeatured },
                isRefreshing = false
            )
        }
    }
}
