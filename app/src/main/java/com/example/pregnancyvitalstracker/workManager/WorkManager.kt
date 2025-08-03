package com.example.pregnancyvitalstracker.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancyvitalstracker.notification.NotificationHelper


class ReminderWorker(
    context: Context,
    params: WorkerParameters,
) : Worker(context, params) {


    override fun doWork(): Result {


        NotificationHelper.showNotification(
            context = applicationContext,
            title = "Time to log your vitals!",
            message = "Stay on top of your health. Please update your vitals now!"
        )

        Log.d("reminder", "return Work Manager : ${Result.success()}")
        return Result.success()
    }
}
