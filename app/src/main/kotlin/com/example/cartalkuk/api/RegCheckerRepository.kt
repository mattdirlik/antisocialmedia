package com.example.cartalkuk.api

import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel

class RegCheckerRepository(
    private val remoteDataSource: RegCheckerRemoteDataSource = RegCheckerRemoteDataSource(),
    private val localDataSource: RegCheckerLocalDataSource = RegCheckerLocalDataSource()
) {
    suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEnquiryResponseModel {
        return localDataSource.getVehicleDetails(request)
    }
}