package com.example.pregnancyvitalstracker.presentation.screens


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals
import com.example.pregnancyvitalstracker.data.repository.VitalsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VitalsViewModel @Inject constructor(
    application: Application,
    private val repository: VitalsRepositoryImpl) : AndroidViewModel(application) {
    val vitalsList = repository.allEntityVitals.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addVitals(entityVitals: EntityVitals) {
        viewModelScope.launch {
            repository.insert(entityVitals)
        }
    }
}
