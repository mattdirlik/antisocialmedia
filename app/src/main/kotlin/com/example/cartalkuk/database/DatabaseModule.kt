package com.example.cartalkuk.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCarTalkDatabases(
        @ApplicationContext context: Context
    ): CarTalkDatabase = Room.databaseBuilder(
        context = context,
        klass = CarTalkDatabase::class.java,
        name = "cartalk-database"
    ).build()
}