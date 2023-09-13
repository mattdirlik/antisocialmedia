package com.example.cartalkuk.api

import com.example.cartalkuk.api.datasource.RegCheckerDataSource
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
class RetrofitNetwork {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { interceptorChain ->
            val request = interceptorChain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()

            interceptorChain.proceed(request)
        }
        .build()

    private val moshi = MoshiConverterFactory.create()

    val networkApi = Retrofit.Builder()
        .baseUrl("https://driver-vehicle-licensing.api.gov.uk/")
        .client(provideOkHttpClient())
        .addConverterFactory(moshi)
        .build()
        .create(RegCheckerDataSource::class.java)
}