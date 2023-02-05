package com.example.cartalkuk.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cartalkuk.ui.home.RegistrationInputComponent
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
            onValueChanged = { homeViewModel.updateRegistration(it) }
        )
    }
}