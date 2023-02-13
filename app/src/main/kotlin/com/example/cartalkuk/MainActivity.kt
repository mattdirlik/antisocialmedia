package com.example.cartalkuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.example.cartalkuk.settings.ColourThemeOptions
import com.example.cartalkuk.ui.appwide.CarTalkTopBar
import com.example.cartalkuk.ui.home.HomeScreen
import com.example.cartalkuk.ui.theme.RegCheckerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegCheckerTheme {
                Column {
                    val drawerState = rememberDrawerState(DrawerValue.Closed)
                    val scope = rememberCoroutineScope()

                    CarTalkTopBar(
                        onSettingsClicked = {
                            scope.launch {
                                if (drawerState.isOpen) {
                                    drawerState.close()
                                } else {
                                    drawerState.open()
                                }
                            }
                        }
                    )

                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            gesturesEnabled = drawerState.isOpen,
                            drawerContent = {
                                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .width(IntrinsicSize.Max),
                                        color = MaterialTheme.colorScheme.background
                                    ) {
                                        ColourThemeOptions()
                                    }
                                }
                            },
                            content = {
                                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        color = MaterialTheme.colorScheme.background
                                    ) {
                                        HomeScreen()
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}