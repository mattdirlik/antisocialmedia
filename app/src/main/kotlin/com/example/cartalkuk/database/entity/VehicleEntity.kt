package com.example.cartalkuk.database.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.cartalkuk.data.CarTalkConstants.GarageDatabase
import com.example.cartalkuk.data.model.VehicleEnquiryApiErrorModel

@Entity(tableName = GarageDatabase)
data class VehicleEntity @JvmOverloads constructor(
    var make: String? = null,
    var colour: String? = null,
    var taxStatus: String? = null,
    var taxDueDate: String? = null,
    var artEndDate: String? = null,
    var motStatus: String? = null,
    var motExpiryDate: String? = null,
    var monthOfFirstDvlaRegistration: String? = null,
    var monthOfFirstRegistration: String? = null,
    var yearOfManufacture: Int? = null,
    var co2Emissions: Int?= null,
    var engineCapacity: Int?= null,
    var fuelType: String? = null,
    var markedForExport: Boolean? = null,
    var typeApproval: String? = null,
    var wheelplan: String? = null,
    var revenueWeight: Int? = null,
    var realDrivingEmissions: String? = null,
    var dateOfLastV5CIssued: String? = null,
    var euroStatus: String? = null,
    var automatedVehicle: Boolean? = null,
    @Ignore
    var errors: List<VehicleEnquiryApiErrorModel>? = listOf(),
    @PrimaryKey
    var registrationNumber: String = ""
)