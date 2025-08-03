package com.example.pregnancyvitalstracker.workManager

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object VitalsReminderScheduler{
    fun scheduleVitalsReminder(context: Context) {
        val request = PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS)
            .build()


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