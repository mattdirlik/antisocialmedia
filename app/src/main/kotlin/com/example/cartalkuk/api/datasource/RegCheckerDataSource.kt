package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.entity.VehicleEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface RegCheckerDataSource {
    @POST("vehicle-enquiry/v1/vehicles")
    suspend fun getVehicleDetails(
        @Body request: VehicleEnquiryRequestModel
    ): VehicleEntity
}