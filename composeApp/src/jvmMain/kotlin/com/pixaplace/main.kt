package com.pixaplace

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.pixaplace.di.KoinInitializer

fun main() = application {

    // Koin setup
    KoinInitializer.start(currentPlatform)

    Window(
        onCloseRequest = ::exitApplication,
        title = "Pixaplace",
    ) {
        App()
    }
}