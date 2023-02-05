package com.example.cartalkuk.api.datasource

import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.data.model.VehicleEnquiryResponseModel
import com.squareup.moshi.Moshi

class RegCheckerLocalDataSource: RegCheckerDataSource {
    override suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEnquiryResponseModel {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(VehicleEnquiryResponseModel::class.java)
        return adapter.fromJson(json)!!
    }
}

private const val json = "{\"artEndDate\":\"2025-02-28\",\"co2Emissions\":135," +
        "\"colour\":\"BLUE\",\"engineCapacity\":2494,\"fuelType\":\"PETROL\",\"make\":\"ROVER\"," +
        "\"markedForExport\":false,\"monthOfFirstRegistration\":\"2004-12\",\"motStatus\":\"No " +
        "details held by DVLA\",\"registrationNumber\":\"ABC1234\",\"revenueWeight\":1640," +
        "\"taxDueDate\":\"2007-01-01\",\"taxStatus\":\"Untaxed\",\"typeApproval\":\"N1\"," +
        "\"wheelplan\":\"NON STANDARD\",\"yearOfManufacture\":2004,\"euroStatus\":\"EURO 6 AD\"," +
        "\"realDrivingEmissions\":\"1\",\"dateOfLastV5CIssued\":\"2016-12-25\"}"