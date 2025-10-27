// shared/src/commonMain/kotlin/ui/screens/AccountScreenWeb.kt
package com.pixaplace.ui.screens.account

import ProfileSection
import SettingsSection
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AccountScreenMobile(
    onLogout: () -> Unit,
    onEditProfile: () -> Unit
) {
    AccountCompactLayout(onLogout, onEditProfile)
}


// ------------------------------------------------------------
//  COMPACT LAYOUT (default for web)
// ------------------------------------------------------------
@Composable
private fun AccountCompactLayout(
    onLogout: () -> Unit,
    onEditProfile: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ProfileSection(onEditProfile)
        SettingsSection(onLogout)
    }
}