package com.example.cartalkuk.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cartalkuk.data.CarTalkConstants.GarageDatabase
import com.example.cartalkuk.data.model.VehicleEnquiryApiErrorModel

@Entity(tableName = GarageDatabase)
data class VehicleEntity(
    @PrimaryKey
    val registrationNumber: String,
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
    val errors: List<VehicleEnquiryApiErrorModel>? = null
)