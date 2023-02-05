package com.example.cartalkuk.ui.home

sealed interface HomeUiState {
    val registration: String

    data class Default(
        override val registration: String
    ) : HomeUiState
}
