package com.example.pregnancyvitalstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.pregnancyvitalstracker.notification.NotificationHelper
import com.example.pregnancyvitalstracker.presentation.screens.VitalsScreen
import com.example.pregnancyvitalstracker.presentation.theme.PregnancyVitalsTrackerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        NotificationHelper.askNotificationPermission(this)
            NotificationHelper.createNotificationChannel(this)
        enableEdgeToEdge()
        setContent {
            PregnancyVitalsTrackerTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    VitalsScreen()
}



