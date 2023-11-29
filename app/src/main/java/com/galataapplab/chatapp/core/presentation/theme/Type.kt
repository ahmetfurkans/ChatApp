package com.galataapplab.chatapp.core.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.galataapplab.chatapp.R

val Mulish = FontFamily(
    Font(R.font.mulish_bold, FontWeight.Bold),
    Font(R.font.mulish_semibold, FontWeight.SemiBold),
    Font(R.font.mulish_regular)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.Bold, fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.Bold, fontSize = 24.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.SemiBold, fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.Normal, fontSize = 14.sp
    ),
    // Metadata 01
    h3 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.Normal, fontSize = 12.sp
    ),
    // Metadata 02
    h4 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.Normal, fontSize = 10.sp
    ),
    // Metadata 03
    h5 = TextStyle(
        fontFamily = Mulish, fontWeight = FontWeight.SemiBold, fontSize = 14.sp
    ),
)