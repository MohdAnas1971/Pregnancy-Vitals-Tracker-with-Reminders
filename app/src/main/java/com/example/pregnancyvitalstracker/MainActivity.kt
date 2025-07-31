package com.example.pregnancyvitalstracker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.pregnancyvitalstracker.ui.screens.VitalsScreen
import com.example.pregnancyvitalstracker.ui.theme.PregnancyVitalsTrackerTheme
import com.example.pregnancyvitalstracker.util.ReminderWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        askNotificationPermission()
        createNotificationChannel(this)
        scheduleVitalsReminder(this)


        enableEdgeToEdge()
        setContent {
            PregnancyVitalsTrackerTheme {
                App()
            }
        }
    }

       fun createNotificationChannel(context: Context) {
           val name = "Vitals Reminder"
           val descriptionText = "Reminds to log vitals"
           val importance = NotificationManager.IMPORTANCE_HIGH
           val channel = NotificationChannel("vitals_channel", name, importance).apply {
               description = descriptionText
           }
           val notificationManager: NotificationManager =
               context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
           notificationManager.createNotificationChannel(channel)
       }

    fun scheduleVitalsReminder(context: Context) {
        val request = PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "VitalsReminder",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    100
                )
            }
        }
    }

}


@Composable
fun App() {
    VitalsScreen()
}



