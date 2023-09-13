package com.example.cartalkuk.database.entity

import androidx.room.TypeConverter
import com.example.cartalkuk.data.model.VehicleEnquiryApiErrorModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class RegCheckerTypeConverters {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private inline fun <reified T> Moshi.jsonToList(json: String): List<T>? =
        adapter<List<T>>(Types.newParameterizedType(List::class.java, T::class.java))
            .fromJson(json)

    private inline fun <reified T> Moshi.listToJson(data: List<T>): String =
        adapter<List<T>>(Types.newParameterizedType(List::class.java, T::class.java))
            .toJson(data)

    @TypeConverter
    fun fromErrorsToJSON(errorList: List<VehicleEnquiryApiErrorModel>): String {
        return moshi.listToJson(errorList)
    }
    @TypeConverter
    fun fromJSONToErrors(json: String): List<VehicleEnquiryApiErrorModel>? {
        return moshi.jsonToList(json)
    }
}