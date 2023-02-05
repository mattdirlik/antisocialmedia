package com.example.cartalkuk.vm.home

import com.example.cartalkuk.ui.home.HomeUiState

data class HomeViewModelState(
    val queriedRegistration: String = ""
) {
    fun toUiState(): HomeUiState =
        HomeUiState.Default(
            registration = queriedRegistration
        )
}
