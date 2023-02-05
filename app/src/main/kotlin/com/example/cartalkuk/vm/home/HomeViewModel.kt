package com.example.cartalkuk.vm.home

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartalkuk.api.RegCheckerRepository
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val repository: RegCheckerRepository = RegCheckerRepository()
) : ViewModel() {
    private var viewModelState by mutableStateOf(HomeViewModelState())
    val uiState by derivedStateOf { viewModelState.toUiState() }

    fun updateRegistration(registration: String) {
        viewModelState = viewModelState.copy(queriedRegistration = registration)
    }

    fun getVehicleDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                try {
                    val response = repository.getVehicleDetails(
                        VehicleEnquiryRequestModel(
                            registrationNumber = viewModelState.queriedRegistration
                        )
                    )

                    viewModelState = viewModelState.copy(errorMessage = response.motStatus)
                } catch (e: Exception) {
                    viewModelState = viewModelState.copy(errorMessage = "whoops")
                }
            }
        }
    }
}