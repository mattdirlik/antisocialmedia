package com.example.cartalkuk.database

import com.example.cartalkuk.database.dao.VehicleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModules {
    @Provides
    fun providesVehicleDao(
        database: CarTalkDatabase
    ): VehicleDao = database.vehicleDao()
}