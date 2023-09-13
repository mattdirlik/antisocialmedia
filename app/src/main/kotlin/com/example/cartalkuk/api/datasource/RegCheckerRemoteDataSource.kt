package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.entity.VehicleEntity
import javax.inject.Inject

class RegCheckerRemoteDataSource @Inject constructor(
    private val service: RegCheckerDataSource
) : RegCheckerDataSource {

    override suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEntity {
        return service.getVehicleDetails(request)
    }
}