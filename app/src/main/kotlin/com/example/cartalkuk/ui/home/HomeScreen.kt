package com.example.cartalkuk.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cartalkuk.ui.queryconfirmation.QueryConfirmationCard
import com.example.cartalkuk.ui.vehicledetails.VehicleDetailsScreen
import com.example.cartalkuk.vm.home.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegistrationInputComponent(
            value = homeViewModel.uiState.registration,
            onValueChanged = { homeViewModel.updateRegistration(it) },
            onSearch = { homeViewModel.getVehicleDetails() }
        )

        with(homeViewModel.uiState) {
            when (this) {
                is HomeUiState.Default -> {
                    LoadingSpinner(
                        modifier = Modifier.padding(24.dp),
                        isShown = isLoadingSpinnerShown
                    )
                }

                is HomeUiState.QueryConfirmation -> {
                    QueryConfirmationCard(
                        onConfirmationButtonClick = { homeViewModel.setQueryConfirmation(it) },
                        colour = colour,
                        make = make
                    )
                }

                is HomeUiState.VehicleDetails -> {
                    VehicleDetailsScreen(
                        vehicle = vehicle
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingSpinner(
    modifier: Modifier = Modifier,
    isShown: Boolean = true
) {
    val spinnerColour = MaterialTheme.colorScheme.primary
    val backColour = Color.Gray
    val strokeWidth = 4.dp
    if (isShown) {
        CircularProgressIndicator(
            modifier = modifier.drawBehind {
                drawCircle(
                    color = spinnerColour,
                    radius = size.width / 2 - strokeWidth.toPx() / 2,
                    style = Stroke(strokeWidth.toPx())
                )
            },
            color = backColour,
            strokeWidth = strokeWidth
        )
    }
}