@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cartalkuk.ui.appwide

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cartalkuk.ui.appwide.TitleBar.AppTitleText

@Composable
fun CarTalkTopBar(
    onSettingsClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { TopBarTitle() },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        actions = {
            IconButton(
                onClick = { onSettingsClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "App settings"
                )
            }
        }
    )
}

@Composable
fun TopBarTitle() {
    Text(
        text = AppTitleText,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Preview
@Composable
fun TitleBarPreview() {
    CarTalkTopBar(onSettingsClicked = {})
}

private object TitleBar {
    const val AppTitleText = "Reg Query UK"
}