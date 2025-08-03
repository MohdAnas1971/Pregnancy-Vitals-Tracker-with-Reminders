package com.example.pregnancyvitalstracker.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pregnancyvitalstracker.presentation.component.CustomSwitchWithIcon
import com.example.pregnancyvitalstracker.presentation.theme.PurpleDark


@Composable
 fun SettingsDialog(onDismiss: () -> Unit, viewModel: VitalsViewModel){

    var isReminderEnabled =viewModel.isReminderEnabled.collectAsState().value



    AlertDialog(
    onDismissRequest = onDismiss,
    title = { Text("Settings") },
    text = {

       Column {
          Row(horizontalArrangement = Arrangement.SpaceBetween,
             verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier.fillMaxWidth()
          ) {

             Text("Vitals Reminder : ")
             CustomSwitchWithIcon(
                isReminderEnabled,
                onChange = {
                   isReminderEnabled=it
                   viewModel.toggleReminder(it)
               })
          }
       }
           },
    icon = {Icon(Icons.Default.Settings, contentDescription = null)},
    confirmButton = {
       Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
          Button(onClick = {
             onDismiss()
          },
             colors = ButtonDefaults.buttonColors(
                containerColor = PurpleDark
             ),
             shape = RoundedCornerShape(5.dp),
           //  modifier = Modifier.width(2.dp)
          ) {
             Text("Done")
          }
       }

    },
)

}
