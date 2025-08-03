package com.example.pregnancyvitalstracker.presentation.screens


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import androidx.lifecycle.viewModelScope
import com.example.pregnancyvitalstracker.data.local.entity.EntityVitals
import com.example.pregnancyvitalstracker.data.repository.VitalsRepositoryImpl
import com.example.pregnancyvitalstracker.workManager.RemenderPreference
import com.example.pregnancyvitalstracker.workManager.VitalsReminderScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VitalsViewModel @Inject constructor(
    application: Application,
    private val repository: VitalsRepositoryImpl
) : AndroidViewModel(application) {


    private val _isReminderEnabled = MutableStateFlow(false)
    val isReminderEnabled: StateFlow<Boolean> = _isReminderEnabled


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


    // To control Vitals REMENDER by Switch
    init {
        viewModelScope.launch {
            RemenderPreference.getReminderEnabled(application).collect {
                _isReminderEnabled.value = it
            }
        }
    }

    fun toggleReminder(enabled: Boolean) {
        _isReminderEnabled.value = enabled
        viewModelScope.launch {
            RemenderPreference.setReminderEnabled(application, enabled)

            Log.d("reminder", "return : $enabled, value: ${isReminderEnabled.value}")

            if (enabled) {
                VitalsReminderScheduler.scheduleVitalsReminder(application)
            } else {
                VitalsReminderScheduler.cancelVitalsReminder(application)
            }
        }
    }


}
