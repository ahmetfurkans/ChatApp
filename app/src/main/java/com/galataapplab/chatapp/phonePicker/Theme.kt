package com.galataapplab.chatapp.phonePicker

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Colors.countryPrimary
    get() = if (isLight) Color(0xFFF7F7FC) else Color(0XFF152033)

val Colors.sheetBackGround
    get() = if (isLight) Color.White else Color(0XFF0F1828)

val Colors.countryPrimaryVariant
    get() = if (isLight) Color(0xFF0F1828) else Color.White
