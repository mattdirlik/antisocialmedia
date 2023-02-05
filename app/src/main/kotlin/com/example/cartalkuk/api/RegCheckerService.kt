package com.example.cartalkuk.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RegCheckerRetrofitObject {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val moshi = MoshiConverterFactory.create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://driver-vehicle-licensing.api.gov.uk/")
        .client(okHttpClient)
        .addConverterFactory(moshi)
        .build()
        .create<RegCheckerDataSource>()
}