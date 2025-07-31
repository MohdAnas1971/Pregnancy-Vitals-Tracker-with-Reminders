package com.example.pregnancyvitalstracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pregnancyvitalstracker.data.model.Vitals
import com.example.pregnancyvitalstracker.ui.theme.PurpleDark

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (Vitals) -> Unit,
) {
    var systolic by remember { mutableStateOf("") }
    var diastolic by remember { mutableStateOf("") }
    var heartRate by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var babyKicks by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Vitals") },
        text = {
            Column {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    InputTexBox(
                        value = systolic,
                        onValueChange = { systolic = it },
                        labelText = "Sys BP",
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(Modifier.width(8.dp))

                    InputTexBox(
                        value = diastolic,
                        onValueChange = { diastolic = it },
                        labelText = "Dia BP",
                        modifier = Modifier.weight(1f),
                    )

                }

                InputTexBox(
                    value = heartRate,
                    onValueChange = {heartRate = it },
                    labelText = "Heart Rate",
                )
                InputTexBox(
                    value = weight,
                    onValueChange = {weight = it},
                    labelText = "Weight(in kg)",
                )
                InputTexBox(
                    value = babyKicks,
                    onValueChange = {  babyKicks = it},
                    labelText = "Baby Kicks",
                )
            }
        },
        confirmButton = {

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    if (systolic.isNotBlank() && diastolic.isNotBlank()) {
                        val vitals = Vitals(
                            systolic = systolic.toInt(),
                            diastolic = diastolic.toInt(),
                            heartRate = heartRate.toInt(),
                            weight = weight.toFloat(),
                            babyKicks = babyKicks.toInt()
                        )
                        onSubmit(vitals)
                        onDismiss()
                    }
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PurpleDark
                    ),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.width(200.dp)
                ) {
                    Text("Submit")
                }
            }
        }
    )
}

@Composable
fun InputTexBox(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(labelText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier,
        shape =RoundedCornerShape(5.dp)
    )
}