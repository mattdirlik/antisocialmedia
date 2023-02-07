package com.example.cartalkuk.api

import com.example.cartalkuk.api.datasource.RegCheckerDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RegCheckerRetrofitObject {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { interceptorChain ->
            val request = interceptorChain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()

            interceptorChain.proceed(request)
        }
        .build()

    private val moshi = MoshiConverterFactory.create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://driver-vehicle-licensing.api.gov.uk/")
        .client(okHttpClient)
        .addConverterFactory(moshi)
        .build()
        .create<RegCheckerDataSource>()
}