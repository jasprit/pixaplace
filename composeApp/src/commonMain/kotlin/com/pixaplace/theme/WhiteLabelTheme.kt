package com.pixaplace.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.theme.WhiteLabelColors
import com.example.theme.WhiteLabelShapes
import com.example.theme.WhiteLabelTypography

@Composable
fun WhiteLabelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = WhiteLabelColors.Primary,
            onPrimary = WhiteLabelColors.OnPrimary,
            background = Color.Black,
            surface = Color.Black,
            onBackground = WhiteLabelColors.OnBackground
        )
    } else {
        lightColorScheme(
            primary = WhiteLabelColors.Primary,
            onPrimary = WhiteLabelColors.OnPrimary,
            background = WhiteLabelColors.Background,
            surface = WhiteLabelColors.Surface,
            onBackground = WhiteLabelColors.OnBackground
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = WhiteLabelTypography,
        shapes = WhiteLabelShapes,
        content = content
    )
}