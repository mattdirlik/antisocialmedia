package com.example.cartalkuk.settings

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cartalkuk.BuildConfig
import com.example.cartalkuk.settings.AppSettings.colourTheme
import com.example.cartalkuk.settings.ColourTheme.Dark
import com.example.cartalkuk.settings.ColourTheme.Light
import com.example.cartalkuk.settings.ColourTheme.System
import com.example.cartalkuk.settings.ColourTheme.valueOf
import com.example.cartalkuk.settings.Settings.ColourTheme
import com.example.cartalkuk.settings.Settings.LicenseLabel
import com.example.cartalkuk.settings.Settings.LicenseText
import com.example.cartalkuk.settings.Settings.LicenseUri

object AppSettings {
    var colourTheme by mutableStateOf(System)
}

enum class ColourTheme {
    Light,
    Dark,
    System
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColourThemeOptions() {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    var isLicensePopupShown by remember { mutableStateOf(false) }

    if (isLicensePopupShown) {
        AlertDialog(
            onDismissRequest = { isLicensePopupShown = false },
            title = {
                Text(
                    text = LicenseLabel,
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            text = { Text(text = LicenseText) },
            confirmButton = {
                TextButton(
                    onClick = { uriHandler.openUri(LicenseUri) }
                ) {
                    Text(text = "View Online")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { isLicensePopupShown = false }
                ) {
                    Text(text = "Cancel")
                }
            },
        )
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .widthIn(min = 0.dp, max = 128.dp)
    ) {
        Text(
            text = "Colour Theme",
            style = MaterialTheme.typography.titleSmall
        )
        ColourThemeOption(
            text = Light.name,
            onClick = {
                colourTheme = Light
                context.setColourThemeFromData(Light)
            }
        )
        ColourThemeOption(
            text = Dark.name,
            onClick = {
                colourTheme = Dark
                context.setColourThemeFromData(Dark)
            }
        )
        ColourThemeOption(
            text = System.name,
            onClick = {
                colourTheme = System
                context.setColourThemeFromData(System)
            }
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "App version: " + BuildConfig.VERSION_NAME,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .clickable {
                    isLicensePopupShown = true
                },
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f, fill = false),
                text = "License: OGL 3.0",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )
            Icon(
                modifier = Modifier.size(12.dp),
                imageVector = Icons.Default.Info,
                contentDescription = "License information"
            )
        }
    }
}

@Composable
fun ColourThemeOption(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(4.dp),
        text = text,
        style = MaterialTheme.typography.bodyMedium,
    )
}

fun Context.getColourThemeFromData(): ColourTheme {
    val colourThemePref = this.getSharedPreferences(
        ColourTheme,
        Context.MODE_PRIVATE
    )

    return colourThemePref?.getString(ColourTheme, System.name)?.let { savedTheme ->
        valueOf(savedTheme)
    } ?: System
}

fun Context.setColourThemeFromData(theme: ColourTheme) {
    val colourThemePref = this.getSharedPreferences(
        ColourTheme,
        Context.MODE_PRIVATE
    )
    with(colourThemePref.edit()) {
        putString(ColourTheme, theme.name)
        apply()
    }
}

internal object Settings {
    const val ColourTheme = "ColourTheme"
    const val LicenseLabel = "Open Government License"
    const val LicenseText = "Contains public sector information licensed under the Open " +
            "Government Licence v3.0"
    const val LicenseUri =
        "https://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/"
}