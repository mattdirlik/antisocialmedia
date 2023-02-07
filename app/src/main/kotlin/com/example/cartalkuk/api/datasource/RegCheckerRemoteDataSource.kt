package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.api.RegCheckerRetrofitObject
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel

class RegCheckerRemoteDataSource(
    private val service: RegCheckerDataSource = RegCheckerRetrofitObject.retrofit
) : RegCheckerDataSource {

    override suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEnquiryResponseModel {
        return service.getVehicleDetails(request)
    }
}