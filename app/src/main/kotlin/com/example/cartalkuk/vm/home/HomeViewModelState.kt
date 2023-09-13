package com.example.cartalkuk.vm.home

import com.example.cartalkuk.database.entity.VehicleEntity
import com.example.cartalkuk.ui.home.HomeUiState

data class HomeViewModelState(
    val queriedRegistration: String = "",
    val vehicle: VehicleEntity? = null,
    val errorMessage: String? = null,
    val isLoadingSpinnerShown: Boolean = false,
    val isVehicleDetailsOpen: Boolean = false
) {
    fun toUiState(): HomeUiState =
        if (vehicle == null) {
            HomeUiState.Default(
                registration = queriedRegistration,
                errorMessage = errorMessage,
                isLoadingSpinnerShown = isLoadingSpinnerShown
            )
        } else {
            if (isVehicleDetailsOpen) {
                HomeUiState.VehicleDetails(
                    registration = queriedRegistration,
                    vehicle = vehicle
                )
            } else {
                HomeUiState.QueryConfirmation(
                    registration = queriedRegistration,
                    make = vehicle.make,
                    colour = vehicle.colour
                )
            }
        }

}
