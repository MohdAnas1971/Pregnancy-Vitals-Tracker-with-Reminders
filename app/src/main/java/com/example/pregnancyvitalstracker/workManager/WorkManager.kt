package com.example.pregnancyvitalstracker.workManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancyvitalstracker.notification.NotificationHelper


class ReminderWorker(
    context: Context,
                     params: WorkerParameters
) : Worker(context, params) {


    override fun doWork(): Result {
        NotificationHelper.showNotification(
            context = applicationContext,
            title = "Time to log your vitals!",
            message = "Stay on top of your health. Please update your vitals now!"
        )
        return Result.success()
    }



}
