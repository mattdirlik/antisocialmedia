package com.example.cartalkuk.vm.garage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cartalkuk.api.RegCheckerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GarageViewModel @Inject constructor(
    private val repository: RegCheckerRepository
) : ViewModel() {
    var state by mutableStateOf(GarageViewModelState())

    init {
        getVehiclesInGarage()
    }

    private fun getVehiclesInGarage() {
        state = state.copy(
            vehicles = repository.getSavedVehicles()
        )
    }

}