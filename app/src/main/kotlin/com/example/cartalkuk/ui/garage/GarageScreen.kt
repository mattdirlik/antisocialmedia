package com.example.cartalkuk.ui.garage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cartalkuk.vm.garage.GarageViewModel

@Composable
fun GarageScreen(
    garageViewModel: GarageViewModel = hiltViewModel()
) {
    LazyColumn(
        horizontalAlignment = CenterHorizontally
    ) {
        items(garageViewModel.state.vehicles) {
            GarageVehicleDetailCard(
                modifier = Modifier.fillMaxWidth(),
                vehicle = it
            )
        }
        item {
            AddCarToGarageButton()
        }
    }
}