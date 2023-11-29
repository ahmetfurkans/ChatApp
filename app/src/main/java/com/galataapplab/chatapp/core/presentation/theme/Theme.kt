package com.galataapplab.chatapp.core.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = BrightBlue,
    background = MidnightBlue,
    onBackground = LightGrey,
    surface = MidnightBlue,
    secondary = MidnightGrey,
    primaryVariant = LightGrey

)

private val LightColorPalette = lightColors(
    primary = DeepBlue,
    background = Color.White,
    onBackground = MidnightBlue,
    surface = LightGrey,
    secondary = GhostWhite,
    primaryVariant = DeepBlue
)

@Composable
fun ChatAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors, typography = Typography, shapes = Shapes, content = content
    )
}