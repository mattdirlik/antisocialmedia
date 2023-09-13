package com.example.cartalkuk.vm.garage

import androidx.lifecycle.ViewModel
import com.example.cartalkuk.api.RegCheckerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GarageViewModel @Inject constructor(
    repository: RegCheckerRepository
) : ViewModel() {
}