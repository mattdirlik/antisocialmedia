package com.example.cartalkuk.vm.home

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartalkuk.api.RegCheckerRepository
import com.example.cartalkuk.api.datasource.RegCheckerRemoteDataSource
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val repository: RegCheckerRepository = RegCheckerRepository(RegCheckerRemoteDataSource())
) : ViewModel() {
    private var viewModelState by mutableStateOf(HomeViewModelState())
    val uiState by derivedStateOf { viewModelState.toUiState() }

    fun updateRegistration(registration: String) {
        viewModelState = viewModelState.copy(queriedRegistration = registration)
    }

    fun getVehicleDetails() {
        viewModelState = viewModelState.copy(
            isLoadingSpinnerShown = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                viewModelState = try {
                    val response = repository.getVehicleDetails(
                        VehicleEnquiryRequestModel(
                            registrationNumber = viewModelState.queriedRegistration
                        )
                    )

                    with(response) {
                        if (errors.isEmpty()) {
                            viewModelState.copy(
                                vehicle = response,
                                isLoadingSpinnerShown = false
                            )
                        } else {
                            viewModelState.copy(
                                errorMessage = errors.first().detail,
                                isLoadingSpinnerShown = false
                            )
                        }
                    }
                } catch (e: Exception) {
                    viewModelState.copy(
                        errorMessage = "whoops",
                        isLoadingSpinnerShown = false
                    )
                }
            }
        }
    }

    fun setVehicleDetailsOpenStatus(isOpen: Boolean) {
        viewModelState = viewModelState.copy(
            isVehicleDetailsOpen = isOpen,
            vehicle = viewModelState.vehicle.takeIf { isOpen }
        )
    }
}