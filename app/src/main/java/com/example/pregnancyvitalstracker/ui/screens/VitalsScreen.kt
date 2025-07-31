package com.example.pregnancyvitalstracker.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pregnancyvitalstracker.R
import com.example.pregnancyvitalstracker.data.model.Vitals
import com.example.pregnancyvitalstracker.ui.theme.Purple70
import com.example.pregnancyvitalstracker.ui.theme.PurpleDark
import com.example.pregnancyvitalstracker.ui.theme.PurpleLight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VitalsScreen(viewModel: VitalsViewModel = hiltViewModel()) {


    val vitalsList by viewModel.vitalsList.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Track My Pregnancy")},
                colors = TopAppBarColors(
                    containerColor = Purple70,
                    scrolledContainerColor = Purple70,
                    navigationIconContentColor = Purple70,
                    titleContentColor = Purple70,
                    actionIconContentColor = Purple70,

                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                shape = CircleShape,
                containerColor = PurpleDark
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Vitals")
            }
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Box {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(vitalsList) { vitals ->
                        VitalsItem(vitals)
                    }
                }
                if (showDialog) {

                    AddVitalsDialog(onDismiss = { showDialog = false }) { vitals ->
                        viewModel.addVitals(vitals)
                        showDialog = false
                    }
                }

            }
        }
    }
}


@Composable
fun VitalsItem(vitals: Vitals) {

    val formatter = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault())
    val formattedTime = formatter.format(Date(vitals.timestamp)).lowercase()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = PurpleLight
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutputShowBox(
                    value = "${vitals.heartRate} bpm",
                    iconId = R.drawable.heart_rate
                )
                Spacer(modifier = Modifier.width(16.dp))

                OutputShowBox(value = " ${vitals.systolic}/${vitals.diastolic} mmHg", iconId = R.drawable.blood_pressure) }
Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutputShowBox(value = "${vitals.weight} kg", iconId = R.drawable.weight)
                Spacer(modifier = Modifier.width(16.dp))
                OutputShowBox(value = "${vitals.babyKicks} Kicks", iconId = R.drawable.newborn)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)

                .background(color = PurpleDark)
                .padding(5.dp)

        ) {
            Text(formattedTime)
        }
    }
}

@Composable
fun OutputShowBox(iconId: Int, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(150.dp)) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(text = value, modifier = Modifier)

    }
}


