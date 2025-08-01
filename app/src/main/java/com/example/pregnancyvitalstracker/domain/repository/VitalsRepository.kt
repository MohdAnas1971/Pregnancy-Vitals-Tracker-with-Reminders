package com.example.pregnancyvitalstracker.domain.repository


import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals
import kotlinx.coroutines.flow.Flow

interface VitalsRepository {
    val allEntityVitals: Flow<List<EntityVitals>>
    suspend fun insert(entityVitals: EntityVitals)
}
