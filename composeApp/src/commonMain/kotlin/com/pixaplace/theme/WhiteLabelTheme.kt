package com.pixaplace.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.theme.DarkColorScheme
import com.example.theme.LightColorScheme
import com.example.theme.WhiteLabelShapes
import com.example.theme.WhiteLabelTypography

@Composable
fun WhiteLabelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = WhiteLabelTypography,
        shapes = WhiteLabelShapes,
        content = content
    )
}
