package com.example.cartalkuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cartalkuk.nav.CarTalkNavHost
import com.example.cartalkuk.ui.appwide.CarTalkBottomNavigation
import com.example.cartalkuk.ui.appwide.CarTalkTopBar
import com.example.cartalkuk.ui.theme.RegCheckerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            RegCheckerTheme {
                Scaffold(
                    topBar = {
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
                    },
                    bottomBar = {
                        CarTalkBottomNavigation(
                            navController = navController
                        )

                    }
                ) { innerPadding ->
                    CarTalkNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }

            }
        }
    }
}