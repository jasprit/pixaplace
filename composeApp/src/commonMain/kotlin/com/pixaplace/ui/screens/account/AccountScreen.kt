package com.pixaplace.ui.screens.account

import androidx.compose.runtime.Composable
import com.pixaplace.isMobile
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun Account() {
    if (isMobile()) {  // Custom fun: Check screen size or platform
        AccountScreenMobile({}, { })
    } else {
        AccountScreenWeb({}, { })
    }
}


@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    Account()
}