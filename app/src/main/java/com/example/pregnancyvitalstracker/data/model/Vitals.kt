package com.example.pregnancyvitalstracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals")
data class Vitals(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val systolic: Int,
    val diastolic: Int,
    val heartRate: Int,
    val weight: Float,
    val babyKicks: Int,
    val timestamp: Long = System.currentTimeMillis()
)