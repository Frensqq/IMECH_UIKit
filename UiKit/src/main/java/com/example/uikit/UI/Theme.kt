package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle

@Composable
fun IMECHTheme(
    content: @Composable () -> Unit,
    color: IMECHColor,
    font: IMECHFont
){

    val colorScheme = remember(color) {
        lightColorScheme(
            primary = color.accent,
            onPrimary = color.black,
            secondary = color.accentInactive,
            surface = color.cardStroke,
            error = color.error,
            background = color.white,
            onTertiary = color.success
        )
    }

    val typography = remember(font) {
        Typography(
            displayLarge = font.displayLarge,
            displayMedium = font.displayMedium,
        headlineLarge = font.headlineLarge,
        headlineMedium = font.headlineMedium,
        headlineSmall = font.headlineSmall,
         titleLarge = font.titleLarge,
        titleMedium = font.titleMedium,
         titleSmall = font.titleSmall,
         bodyLarge = font.bodyLarge,
         bodyMedium = font.bodyMedium,
         bodySmall = font.bodySmall,
         labelLarge = font.labelLarge,
         labelMedium = font.labelMedium,
        labelSmall = font.labelSmall,
        )
    }

    CompositionLocalProvider(
        LocalIMECHColor provides color,
        LocalIMECHFont provides font
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography
        ) {
            content()
        }
    }
}

object FNCHTheme {

    val color: IMECHColor
        @Composable get() = defaultColor
    val typography: IMECHFont
        @Composable get() = defaultFont


}