package com.example.pregnancyvitalstracker.data.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pregnancyvitalstracker.data.model.Vitals
import com.example.pregnancyvitalstracker.data.model.VitalsDao

@Database(
    entities = [Vitals::class],
    version = 1,
    exportSchema = false
)
abstract class VitalsDatabase : RoomDatabase() {
    abstract fun vitalsDao(): VitalsDao
}