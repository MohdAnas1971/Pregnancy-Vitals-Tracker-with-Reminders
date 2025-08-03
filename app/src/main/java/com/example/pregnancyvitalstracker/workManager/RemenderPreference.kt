package com.example.pregnancyvitalstracker.workManager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


object RemenderPreference{
    private val Context.dataStore by preferencesDataStore("reminder_prefs")
    private val REMINDER_ENABLED = booleanPreferencesKey("reminder_enabled")

    suspend fun  setReminderEnabled(context: Context,enabled: Boolean){
        context.dataStore.edit { prefs->

            prefs[REMINDER_ENABLED]=enabled

        }

    }

    fun getReminderEnabled(context: Context): Flow<Boolean>{
        return context.dataStore.data.map { prefs->
            prefs[REMINDER_ENABLED] ?:false
        }
    }

}