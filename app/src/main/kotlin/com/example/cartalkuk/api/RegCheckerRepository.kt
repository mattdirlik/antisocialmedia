package com.example.cartalkuk.api

import com.example.cartalkuk.api.datasource.RegCheckerRemoteDataSource
import com.example.cartalkuk.data.model.VehicleEnquiryRequestModel
import com.example.cartalkuk.database.dao.VehicleDao
import com.example.cartalkuk.database.entity.VehicleEntity
import javax.inject.Inject

class RegCheckerRepository @Inject constructor(
    private val dataSource: RegCheckerRemoteDataSource,
    private val vehicleDao: VehicleDao
) {
    suspend fun getVehicleDetails(
        request: VehicleEnquiryRequestModel
    ): VehicleEntity {
        return dataSource.getVehicleDetails(request)
    }

    fun getSavedVehicles() = vehicleDao.getAll()

    fun upsertVehicle(vehicle: VehicleEntity) = vehicleDao.upsertVehicle(vehicle = vehicle)
}