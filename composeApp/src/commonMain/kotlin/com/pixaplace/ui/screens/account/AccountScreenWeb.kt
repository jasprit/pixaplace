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
fun AccountScreenWeb(
    onLogout: () -> Unit,
    onEditProfile: () -> Unit
) {
    AccountExpandedLayout(onLogout, onEditProfile)
}

// ------------------------------------------------------------
//  EXPANDED LAYOUT (default for web)
// ------------------------------------------------------------
@Composable
private fun AccountExpandedLayout(
    onLogout: () -> Unit,
    onEditProfile: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 48.dp, vertical = 32.dp)
    ) {
        // ────── LEFT: PROFILE CARD ──────
        Card(
            modifier = Modifier
                .width(360.dp)
                .padding(end = 32.dp),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            ProfileSection(onEditProfile)
        }

        // ────── RIGHT: SETTINGS CARD ──────
        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            SettingsSection(onLogout)
        }
    }
}