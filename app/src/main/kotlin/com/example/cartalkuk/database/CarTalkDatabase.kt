package com.example.cartalkuk.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cartalkuk.database.dao.VehicleDao
import com.example.cartalkuk.database.entity.VehicleEntity

@Database(
    entities = [VehicleEntity::class],
    version = 1
)
abstract class CarTalkDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}