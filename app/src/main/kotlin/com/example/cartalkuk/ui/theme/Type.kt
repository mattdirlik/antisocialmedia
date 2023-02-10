package com.example.cartalkuk.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cartalkuk.R

val MavenStandard = FontFamily(
    Font(
        resId = R.font.mavenpro
    )
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = MavenStandard,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
)