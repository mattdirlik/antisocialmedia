package com.example.cartalkuk.ui.garage

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun GarageScreen() {
    LazyColumn {
        item {
            AddCarToGarageButton()
        }
    }
}