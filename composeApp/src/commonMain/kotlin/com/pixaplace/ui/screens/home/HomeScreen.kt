package com.pixaplace.ui.screens.home

import HomeScreenMobile
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.pixaplace.isMobile
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun Home() {

    val viewModel = DealsViewModel() // Use your Koin/Hilt

    val state by viewModel.uiState.collectAsState()
    // val windowSize = calculateWindowSizeClass()

    if (isMobile()) {  // Custom fun: Check screen size or platform
        HomeScreenMobile { /* More */ }
    } else {
        DealsHomeWeb(state, { }, { })
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}