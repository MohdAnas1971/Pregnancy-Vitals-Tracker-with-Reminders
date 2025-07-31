package com.example.pregnancyvitalstracker.util

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancyvitalstracker.MainActivity
import com.example.pregnancyvitalstracker.R


class ReminderWorker(
    context: Context,
                     params: WorkerParameters
) : Worker(context, params) {


    override fun doWork(): Result {
        showNotification(
            context = applicationContext,
            title = "Time to log your vitals!",
            message = "Stay on top of your health. Please update your vitals now!"
        )
        return Result.success()
    }

    private fun showNotification(context: Context, title: String, message: String) {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(context, "vitals_channel")
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(1, notification)
        } else {
            // You may want to log or handle the case where permission is not granted
            Log.w("Notification", "POST_NOTIFICATIONS permission not granted")
        }
    }
}
