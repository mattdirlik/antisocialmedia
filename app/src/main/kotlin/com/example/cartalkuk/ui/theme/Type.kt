package com.example.cartalkuk.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
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

val CharlesWright = FontFamily(
    Font(
        resId = R.font.charleswrightbold
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
    headlineLarge = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
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
    bodySmall = TextStyle(
        fontFamily = MavenStandard,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Black,
        fontSize = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = MavenStandard,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp
    )
)

val RegPlateTextStyle = TextStyle(
    color = Color.Black,
    fontFamily = CharlesWright,
    fontSize = 24.sp,
    letterSpacing = 0.5.sp
)