package com.pixaplace.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Home() {
    Column {
        Text("Home Screen")
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}