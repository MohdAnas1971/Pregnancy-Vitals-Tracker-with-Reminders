package com.example.pregnancyvitalstracker.data.repository

import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals
import com.example.pregnancyvitalstracker.data.local.dao.VitalsDao
import com.example.pregnancyvitalstracker.domain.repository.VitalsRepository
import kotlinx.coroutines.flow.Flow

class VitalsRepositoryImpl(private val dao: VitalsDao): VitalsRepository {
    override val allEntityVitals: Flow<List<EntityVitals>> = dao.getAllVitals()
    override suspend fun insert(entityVitals: EntityVitals) = dao.insertVitals(entityVitals)
}

