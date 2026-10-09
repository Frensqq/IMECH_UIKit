package com.example.uikit.UI

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import kotlin.math.acosh

data class IMECHColor(
    val accent: Color,
    val accentInactive: Color,
    val black: Color,
    val white: Color,
    val error: Color,
    val success: Color,
    val cardStroke: Color,


    val buttonGradientStart: Color,
    val buttonGradientEnd: Color,
)

val defaultColor  = IMECHColor(
    accent = Color(0xffFC597A),
    accentInactive = Color(0xffFDC2CF) ,
            black = Color(0xff000000),
    white = Color(0xffffffff),
    error = Color(0xffFF4646),
    success = Color(0xff08F403),
    cardStroke = Color(0xffF4C73E),
    buttonGradientStart = Color(0xffFF6480),
    buttonGradientEnd = Color(0xffF22E63)
)

val LocalIMECHColor = compositionLocalOf { defaultColor }