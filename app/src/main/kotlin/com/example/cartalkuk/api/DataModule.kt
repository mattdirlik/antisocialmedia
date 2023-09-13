package com.example.cartalkuk.api

import com.example.cartalkuk.api.datasource.RegCheckerRemoteDataSource
import com.example.cartalkuk.database.dao.VehicleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun providesRegCheckerRemoteDataSource(
        regCheckerService: RegCheckerService
    ) = RegCheckerRemoteDataSource(regCheckerService)

    @Singleton
    @Provides
    fun provideRegCheckerRepository(
        remoteDataSource: RegCheckerRemoteDataSource,
        vehicleDao: VehicleDao
    ) = RegCheckerRepository(remoteDataSource, vehicleDao)
}
