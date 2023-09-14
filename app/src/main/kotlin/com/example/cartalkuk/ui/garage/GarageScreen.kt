package com.example.cartalkuk.ui.garage

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cartalkuk.vm.garage.GarageViewModel

@Composable
fun GarageScreen(
    garageViewModel: GarageViewModel = hiltViewModel()
) {
    LazyColumn {
        items(garageViewModel.state.vehicles) {
            Text(text = it.registrationNumber)
        }
        item {
            AddCarToGarageButton()
        }
    }
}