package com.example.pregnancyvitalstracker.workManager

import android.content.Context
import android.util.Log
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.impl.WorkManagerImpl
import java.util.concurrent.TimeUnit

object VitalsReminderScheduler{
    fun scheduleVitalsReminder(context: Context) {
        val request = PeriodicWorkRequestBuilder<ReminderWorker>(2, TimeUnit.MINUTES)
            .build()

        Log.d("reminder", "return : ${request.tags}, value")

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "VitalsReminder",
            ExistingPeriodicWorkPolicy.UPDATE,
            request
        )
    }
    //to cancel Reminder of 5 hours
    fun cancelVitalsReminder(context: Context){
        WorkManager.getInstance(context).cancelAllWorkByTag("VitalsReminder")
    }
}