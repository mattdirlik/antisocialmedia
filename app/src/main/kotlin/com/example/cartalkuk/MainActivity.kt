package com.example.cartalkuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.example.cartalkuk.ui.home.HomeScreen
import com.example.cartalkuk.ui.appwide.CarTalkTopBar
import com.example.cartalkuk.ui.theme.AntisocialmediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AntisocialmediaTheme {
                Column {
                    CarTalkTopBar()
                    HomeScreen()
                }
            }
        }
    }
}