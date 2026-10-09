package com.example.uikit.UI

import androidx.compose.material3.Typography
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import kotlin.math.acosh

data class IMECHFont(
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

/**
 * стиль текста
 *
 * @param fontId - Адрес шрифта
 * @param fontSize - размер шрифта
 * @param letterSpacing - меж-буквенный отступ
 *
 * ЛядовС - 09.10.26
 */
fun textStyle(
    fontId: Int = R.font.bold,
    fontSize: Int,
    letterSpacing: Float = 0f
) = TextStyle(
    fontFamily = FontFamily(Font(fontId)),
    fontSize =fontSize.sp,
    letterSpacing = letterSpacing.sp
)

val defaultFont  = IMECHFont(
    textStyle(fontSize = 30, letterSpacing = 0.3f),
    textStyle(fontSize = 22, letterSpacing = 0.3f),
    textStyle(fontSize = 16),
    textStyle(R.font.regular,fontSize = 16),
    textStyle(fontSize = 14),
    textStyle(fontSize = 12, letterSpacing = -0.3f),
    textStyle(R.font.regular,fontSize = 12),
    textStyle(fontSize = 10, letterSpacing = 0.3F),
    textStyle(R.font.regular,fontSize = 10, letterSpacing = 0.3F),
    textStyle(fontSize = 9),
    textStyle(fontSize = 8),
    textStyle(fontSize = 6),
    textStyle(R.font.regular,fontSize = 6),
    textStyle(R.font.regular,fontSize = 4),

)

val LocalIMECHFont = compositionLocalOf { defaultFont }