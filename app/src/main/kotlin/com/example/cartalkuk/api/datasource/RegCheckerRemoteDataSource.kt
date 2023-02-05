package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.api.RegCheckerRetrofitObject
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

class RegCheckerRemoteDataSource(
    private val service: RegCheckerDataSource = RegCheckerRetrofitObject.retrofit
) : RegCheckerDataSource {

    @POST("vehicle-enquiry/v1/vehicles")
    override suspend fun getVehicleDetails(
        @Body request: VehicleEnquiryRequestModel
    ): VehicleEnquiryResponseModel {
        return service.getVehicleDetails(request)
    }
}