package com.example.pregnancyvitalstracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertVitals(entityVitals: EntityVitals)

    @Query("SELECT * FROM vitals ORDER BY timestamp DESC")
    fun getAllVitals(): Flow<List<EntityVitals>>

}