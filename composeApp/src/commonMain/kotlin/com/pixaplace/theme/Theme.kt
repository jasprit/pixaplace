package com.example.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ─────────────────────────────────────────────────────────────────────────────
// 1. COLOR PALETTE
// ─────────────────────────────────────────────────────────────────────────────
object WhiteLabelColors {
    // Brand Core
    val Primary = Color(0xFFDB94AC)      // #DB94AC
    val OnPrimary = Color(0xFFFFFFFF)

    val Secondary = Color(0xFFDAA195)    // #DAA195
    val OnSecondary = Color(0xFFFFFFFF)

    val Accent = Color(0xFF57C79B)       // #57C79B
    val OnAccent = Color(0xFF29191A)     // #29191A

    // Backgrounds
    val BackgroundLight = Color(0xFFFFFBFA) // #FFFBFA
    val SurfaceLight = Color(0xFFFFFFFF)
    val OnBackgroundLight = Color(0xFF29191A)
    val OnSurfaceLight = Color(0xFF29191A)

    // Dark mode (optional – generated from palette)
    val BackgroundDark = Color(0xFF1A1111)
    val SurfaceDark = Color(0xFF2F2526)
    val OnBackgroundDark = Color(0xFFF4F0F0)
    val OnSurfaceDark = Color(0xFFF4F0F0)

    // Semantic
    val Success = Accent
    val Warning = Color(0xFFFFC107)
    val Error = Color(0xFFD32F2F)
    val DividerLight = Color(0xFFEAD0CC)
    val DividerDark = Color(0xFF4B3E3D)

    // Neutral Scale (from Figma rows)
    object Neutral {
        val N10 = Color(0xFFF4F0F0)
        val N20 = Color(0xFFEAD0CC)
        val N30 = Color(0xFFDAA195)
        val N40 = Color(0xFFB09CA0)
        val N50 = Color(0xFF8E7C7A)
        val N60 = Color(0xFF6B5C5B)
        val N70 = Color(0xFF4B3E3D)
        val N80 = Color(0xFF2F2526)
        val N90 = Color(0xFF1A1111)
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// 2. TYPOGRAPHY
// ─────────────────────────────────────────────────────────────────────────────
val WhiteLabelTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 36.sp
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
)

// ─────────────────────────────────────────────────────────────────────────────
// 3. SHAPES
// ─────────────────────────────────────────────────────────────────────────────
val WhiteLabelShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(25.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

// ─────────────────────────────────────────────────────────────────────────────
// 4. LIGHT COLOR SCHEME
// ─────────────────────────────────────────────────────────────────────────────
val LightColorScheme = lightColorScheme(
    primary = WhiteLabelColors.Primary,
    onPrimary = WhiteLabelColors.OnPrimary,
    secondary = WhiteLabelColors.Secondary,
    onSecondary = WhiteLabelColors.OnSecondary,
    tertiary = WhiteLabelColors.Accent,
    onTertiary = WhiteLabelColors.OnAccent,

    background = WhiteLabelColors.BackgroundLight,
    onBackground = WhiteLabelColors.OnBackgroundLight,
    surface = WhiteLabelColors.SurfaceLight,
    onSurface = WhiteLabelColors.OnSurfaceLight,

    error = WhiteLabelColors.Error,
    onError = Color.White,

    outline = WhiteLabelColors.Neutral.N40,
    surfaceVariant = WhiteLabelColors.Neutral.N10,
    onSurfaceVariant = WhiteLabelColors.Neutral.N60
)

// ─────────────────────────────────────────────────────────────────────────────
// 5. DARK COLOR SCHEME (Optional)
// ─────────────────────────────────────────────────────────────────────────────
val DarkColorScheme = darkColorScheme(
    primary = WhiteLabelColors.Primary,
    onPrimary = WhiteLabelColors.OnPrimary,
    secondary = WhiteLabelColors.Secondary,
    onSecondary = WhiteLabelColors.OnSecondary,
    tertiary = WhiteLabelColors.Accent,
    onTertiary = WhiteLabelColors.OnAccent,

    background = WhiteLabelColors.BackgroundDark,
    onBackground = WhiteLabelColors.OnBackgroundDark,
    surface = WhiteLabelColors.SurfaceDark,
    onSurface = WhiteLabelColors.OnSurfaceDark,

    error = WhiteLabelColors.Error,
    onError = Color.White,

    outline = WhiteLabelColors.Neutral.N50,
    surfaceVariant = WhiteLabelColors.Neutral.N80,
    onSurfaceVariant = WhiteLabelColors.Neutral.N30
)