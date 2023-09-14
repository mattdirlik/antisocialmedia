package com.example.cartalkuk.vm.garage

import com.example.cartalkuk.database.entity.VehicleEntity

data class GarageViewModelState(
    val vehicles: List<VehicleEntity> = listOf()
)
