package com.example.cartalkuk.api

import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.entity.VehicleEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface RegCheckerService {
    @POST("vehicle-enquiry/v1/vehicles")
    suspend fun getVehicleDetails(
        @Body request: VehicleEnquiryRequestModel
    ): VehicleEntity
}