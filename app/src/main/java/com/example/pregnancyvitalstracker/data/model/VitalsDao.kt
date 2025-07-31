package com.example.pregnancyvitalstracker.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertVitals(vitals: Vitals)

    @Query("SELECT * FROM vitals ORDER BY timestamp DESC")
    fun getAllVitals(): Flow<List<Vitals>>

}