package com.pixaplace.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun SidebarMenu(
    navController: NavHostController,
    items: List<NavItem>,
    width: Dp
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val themeColors = androidx.compose.material3.MaterialTheme.colorScheme

    // Calculate top padding as 25% of screen height
    val topPadding = 200.dp

    Card(
        modifier = Modifier
            .width(width)
            .fillMaxHeight()
            .padding(8.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = themeColors.surface)
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .fillMaxHeight()
                .shadow(8.dp, shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                .background(themeColors.surface) // use theme surface color
                .padding(top = topPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route
                val backgroundColor =
                    if (selected) themeColors.primary.copy(alpha = 0.2f) else Color.Transparent
                val textColor = if (selected) themeColors.primary else themeColors.onSurface

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .clickable {
                            if (!selected) navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row {
                        item.icon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = item.label,
                                tint = textColor, // optional: to match your text color or theme
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = item.label,
                            color = textColor,
                            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}