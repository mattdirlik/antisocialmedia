package com.example.cartalkuk.api

import com.example.cartalkuk.api.datasource.RegCheckerDataSource
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel

class RegCheckerRepository(
    private val dataSource: RegCheckerDataSource,
) {
    suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEnquiryResponseModel {
        return dataSource.getVehicleDetails(request)
    }
}