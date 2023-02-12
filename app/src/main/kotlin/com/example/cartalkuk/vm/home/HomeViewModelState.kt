package com.example.cartalkuk.vm.home

import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel
import com.example.cartalkuk.ui.home.HomeUiState

data class HomeViewModelState(
    val queriedRegistration: String = "",
    val isQueryConfirmed: Boolean = false,
    val vehicle: VehicleEnquiryResponseModel? = null,
    val errorMessage: String? = null,
    val isLoadingSpinnerShown: Boolean = false
) {
    fun toUiState(): HomeUiState =
        if (vehicle == null) {
            HomeUiState.Default(
                registration = queriedRegistration,
                errorMessage = errorMessage,
                isLoadingSpinnerShown = isLoadingSpinnerShown
            )
        } else {
            if (isQueryConfirmed) {
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
