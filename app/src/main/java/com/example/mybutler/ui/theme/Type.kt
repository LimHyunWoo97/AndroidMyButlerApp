package com.example.mybutler.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mybutler.R

val freesentation = FontFamily(
    Font(R.font.freesentation_black, FontWeight.W900, FontStyle.Normal),
    Font(R.font.freesentation_bold, FontWeight.W700, FontStyle.Normal),
    Font(R.font.freesentation_extra_bold, FontWeight.W800, FontStyle.Normal),
    Font(R.font.freesentation_extra_light, FontWeight.W200, FontStyle.Normal),
    Font(R.font.freesentation_light, FontWeight.W300, FontStyle.Normal),
    Font(R.font.freesentation_medium, FontWeight.W500, FontStyle.Normal),
    Font(R.font.freesentation_regular, FontWeight.W400, FontStyle.Normal),
    Font(R.font.freesentation_semi_bold, FontWeight.W600, FontStyle.Normal),
    Font(R.font.freesentation_thin, FontWeight.W100, FontStyle.Normal),

    )
val wissi_list = FontFamily(
    Font(R.font.wissi_list, FontWeight.W800, FontStyle.Normal)
)

// Set of Material typography styles to start with
val CustomTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = freesentation,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = freesentation,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)