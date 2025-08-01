package com.example.pregnancyvitalstracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pregnancyvitalstracker.data.local.dao.VitalsDao
import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals

@Database(
    entities = [EntityVitals::class],
    version = 1,
    exportSchema = false
)
abstract class VitalsDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao
}