package com.example.cartalkuk.vm.home

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartalkuk.api.RegCheckerRepository
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.entity.VehicleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RegCheckerRepository
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
                        if (errors.isNullOrEmpty()) {
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
                        errorMessage = e.message,
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

    fun upsertVehicleToGarage(vehicleEntity: VehicleEntity) {
        repository.upsertVehicle(vehicleEntity)
    }
}