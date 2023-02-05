@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cartalkuk.ui.appwide

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartalkuk.ui.appwide.TitleBar.AppTitleText

@Composable
fun CarTalkTopBar() {
    CenterAlignedTopAppBar(
        title = { TopBarTitle() },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
fun TopBarTitle() {
    Text(
        text = AppTitleText,
        fontSize = 30.sp,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Preview
@Composable
fun TitleBarPreview() {
    CarTalkTopBar()
}

private object TitleBar {
    const val AppTitleText = "Reg Query UK"
}