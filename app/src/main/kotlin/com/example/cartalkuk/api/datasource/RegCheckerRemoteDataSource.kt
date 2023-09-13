package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.api.RegCheckerService
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.entity.VehicleEntity
import javax.inject.Inject

class RegCheckerRemoteDataSource @Inject constructor(
    private val regCheckerService: RegCheckerService
) {
    suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEntity {
        return regCheckerService.getVehicleDetails(request)
    }
}