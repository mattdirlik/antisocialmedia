package com.example.cartalkuk.ui.home

import com.example.cartalkuk.database.entity.VehicleEntity

sealed interface HomeUiState {
    val registration: String

    data class Default(
        override val registration: String,
        val errorMessage: String?,
        val isLoadingSpinnerShown: Boolean
    ): HomeUiState

    data class QueryConfirmation(
        override val registration: String,
        val make: String?,
        val colour: String?
    ): HomeUiState

    data class VehicleDetails(
        override val registration: String,
        val vehicle: VehicleEntity
    ): HomeUiState
}
