package com.example.cartalkuk.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.cartalkuk.database.entity.VehicleEntity

@Dao
interface VehicleDao {
    @Query("SELECT * FROM garage")
    fun getAll(): List<VehicleEntity>

    @Upsert
    fun upsertVehicle(vehicle: VehicleEntity)
}