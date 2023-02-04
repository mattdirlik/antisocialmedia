package com.example.cartalkuk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cartalkuk.ui.theme.AntisocialmediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AntisocialmediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AppTitle()
                    }
                }
            }
        }
    }
}

@Composable
fun AppTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "Welcome to the Anti-Social Media app",
        textAlign = TextAlign.Center,
        fontSize = 24.sp
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AntisocialmediaTheme {
        AppTitle()
    }
}