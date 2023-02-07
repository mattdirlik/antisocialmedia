package com.example.cartalkuk.data.model

data class VehicleEnquiryResponseModel(
    val registrationNumber: String? = null,
    val make: String? = null,
    val colour: String? = null,
    val taxStatus: String? = null,
    val taxDueDate: String? = null,
    val artEndDate: String? = null,
    val motStatus: String? = null,
    val motExpiryDate: String? = null,
    val monthOfFirstDvlaRegistration: String? = null,
    val monthOfFirstRegistration: String? = null,
    val yearOfManufacture: Int? = null,
    val co2Emissions: Int? = null,
    val engineCapacity: Int? = null,
    val fuelType: String? = null,
    val markedForExport: Boolean? = null,
    val typeApproval: String? = null,
    val wheelplan: String? = null,
    val revenueWeight: Int? = null,
    val realDrivingEmissions: String? = null,
    val dateOfLastV5CIssued: String? = null,
    val euroStatus: String? = null,
    val automatedVehicle: Boolean? = null,
    val errors: List<VehicleEnquiryApiErrorModel> = listOf()
)