package com.example.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --- Colors ---
object WhiteLabelColors {
    // Brand primary colors
    val Primary = Color(0xFF5E35B1)      // Deep purple
    val OnPrimary = Color(0xFFFFFFFF)    // Text/icons on primary

    // Backgrounds
    val Background = Color(0xFFFFFFFF)   // Screen background
    val Surface = Color(0xFFF3E5F5)      // Cards, sheets

    // Text colors
    val OnBackground = Color(0xFF1C1C1E) // Main body text
    val OnSurface = Color(0xFF5E35B1)    // Text/icons on surface

    // Secondary / accents
    val Secondary = Color(0xFF9575CD)    // Secondary actions
    val Accent = Color(0xFFD1C4E9)       // Highlights / hover / subtle UI
}

// --- Typography ---
val WhiteLabelTypography = Typography(
    displayLarge = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
    headlineMedium = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold),
    bodyLarge = TextStyle(fontSize = 16.sp),
    titleMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
)

// --- Shapes ---
val WhiteLabelShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(25.dp)
)