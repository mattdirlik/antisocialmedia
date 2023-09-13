package com.example.cartalkuk.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cartalkuk.database.dao.VehicleDao
import com.example.cartalkuk.database.entity.RegCheckerTypeConverters
import com.example.cartalkuk.database.entity.VehicleEntity

@TypeConverters(value = [RegCheckerTypeConverters::class])
@Database(
    entities = [VehicleEntity::class],
    version = 1
)
abstract class CarTalkDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}