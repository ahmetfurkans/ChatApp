package com.galataapplab.chatapp.core.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DeepBlue = Color(0xFF002DE3)
val BrightBlue = Color(0xFF375FFF)
val MidnightBlue = Color(0xFF0F1828)
val LightGrey = Color(0xFFF7F7FC)


val MidnightGrey = Color(0xFF152033)
val GhostWhite = Color(0xFFEDEDED)

val LightBlue = Color(0xFF7E95F0)
val Gray = Color(0xFFADB5BD)


val Colors.primaryButton
    get() = if (isLight) DeepBlue else GhostWhite

val Colors.countryPrimary
    get() = if (isLight) Color(0xFFF7F7FC) else Color(0XFF152033)


val Colors.inactivePrimaryButton
    get() = if (isLight) DeepBlue.copy(alpha = 0.7f) else BrightBlue.copy(alpha = 0.7f)

val Colors.placeHolderColor get() = Gray