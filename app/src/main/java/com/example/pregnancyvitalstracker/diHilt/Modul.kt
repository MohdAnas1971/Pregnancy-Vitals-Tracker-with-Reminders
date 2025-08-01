package com.example.pregnancyvitalstracker.diHilt

import dagger.Module
import dagger.hilt.InstallIn
import android.content.Context
import androidx.room.Room
import com.example.pregnancyvitalstracker.data.local.VitalsDatabase
import com.example.pregnancyvitalstracker.data.local.dao.VitalsDao
import com.example.pregnancyvitalstracker.data.repository.VitalsRepositoryImpl


import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VitalsDatabase {
        return Room.databaseBuilder(
            context,
            VitalsDatabase::class.java,
            "vitals_db"
        ).build()
    }

    @Provides
    fun provideVitalsDao(db: VitalsDatabase): VitalsDao = db.vitalsDao()

    @Provides
    @Singleton
    fun provideVitalsRepository(dao: VitalsDao): VitalsRepositoryImpl {
        return VitalsRepositoryImpl(dao)
    }
}
