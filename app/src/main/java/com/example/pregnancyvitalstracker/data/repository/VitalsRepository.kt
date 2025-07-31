package com.example.pregnancyvitalstracker.data.repository

import com.example.pregnancyvitalstracker.data.model.Vitals
import com.example.pregnancyvitalstracker.data.model.VitalsDao
import kotlinx.coroutines.flow.Flow

class VitalsRepository(private val dao: VitalsDao) {
    val allVitals: Flow<List<Vitals>> = dao.getAllVitals()
    suspend fun insert(vitals: Vitals) = dao.insertVitals(vitals)
}
