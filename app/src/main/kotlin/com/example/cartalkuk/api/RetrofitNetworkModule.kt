package com.example.cartalkuk.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor { interceptorChain ->
            val request = interceptorChain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()

            interceptorChain.proceed(request)
        }
        .build()

    @Singleton
    @Provides
    fun provideMoshiConverter() = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideRegCheckerService(
        okHttpClient: OkHttpClient,
        moshiConverter: MoshiConverterFactory
    ) = Retrofit.Builder()
        .baseUrl("https://driver-vehicle-licensing.api.gov.uk/")
        .client(okHttpClient)
        .addConverterFactory(moshiConverter)
        .build()
        .create(RegCheckerService::class.java)
}