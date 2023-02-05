package com.example.cartalkuk.vm.home

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var viewModelState by mutableStateOf(HomeViewModelState())
    val uiState by derivedStateOf { viewModelState.toUiState() }

    fun updateRegistration(registration: String) {
        viewModelState = viewModelState.copy(queriedRegistration = registration)
    }
}