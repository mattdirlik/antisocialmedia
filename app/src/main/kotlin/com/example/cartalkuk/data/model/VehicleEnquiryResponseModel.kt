package com.example.cartalkuk.data.model

data class VehicleEnquiryResponseModel(
    val artEndDate: String? = null,
    val co2Emissions: Int? = null,
    val colour: String? = null,
    val engineCapacity: Int? = null,
    val fuelType: String? = null,
    val make: String? = null,
    val markedForExport: Boolean? = null,
    val monthOfFirstRegistration: String? = null,
    val motStatus: String? = null,
    val registrationNumber: String? = null,
    val revenueWeight: Int? = null,
    val taxDueDate: String? = null,
    val taxStatus: String? = null,
    val typeApproval: String? = null,
    val wheelplan: String? = null,
    val yearOfManufacture: Int? = null,
    val euroStatus: String? = null,
    val realDrivingEmissions: String? = null,
    val dateOfLastV5CIssued: String? = null,
    val errors: List<VehicleEnquiryApiErrorModel> = listOf()
)