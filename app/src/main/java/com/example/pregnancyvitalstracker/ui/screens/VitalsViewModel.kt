package com.example.pregnancyvitalstracker.ui.screens


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pregnancyvitalstracker.data.model.Vitals
import com.example.pregnancyvitalstracker.data.repository.VitalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VitalsViewModel @Inject constructor(
    application: Application,
    private val repository: VitalsRepository) : AndroidViewModel(application) {
    val vitalsList = repository.allVitals.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addVitals(vitals: Vitals) {
        viewModelScope.launch {
            repository.insert(vitals)
        }
    }
}
