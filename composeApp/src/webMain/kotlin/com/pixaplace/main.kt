package com.pixaplace

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.pixaplace.di.KoinInitializer

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    // Koin setup
    KoinInitializer.start(currentPlatform)

    ComposeViewport {
        App()
    }
}