package com.pixaplace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.theme.WhiteLabelColors
import com.pixaplace.theme.WhiteLabelTheme
import com.pixaplace.ui.navigation.RootNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    WhiteLabelTheme { // removed MaterialTheme
        Surface(modifier = Modifier.fillMaxSize(), color = WhiteLabelColors.Background) {
            RootNavGraph()
        }
    }
}