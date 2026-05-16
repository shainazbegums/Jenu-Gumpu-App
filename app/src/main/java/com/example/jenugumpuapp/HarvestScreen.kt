package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.jenugumpuapp.database.AppDatabase
import com.example.jenugumpuapp.model.Harvest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarvestScreen(navController: NavController) {

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "jenu_database"
    ).build()

    val harvestDao = db.harvestDao()

    var harvestDate by remember {
        mutableStateOf("")
    }

    var location by remember {
        mutableStateOf("")
    }

    var quantity by remember {
        mutableStateOf("")
    }

    var resultText by remember {
        mutableStateOf("")
    }

    var generatedBatchId by remember {
        mutableStateOf("")
    }

    val floralSources = listOf(
        "Wildflower",
        "Coffee Blossom",
        "Forest Honey",
        "Neem Honey"
    )

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedFloralSource by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp)
    ) {

        Text(
            text = "Harvest Log",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = harvestDate,
            onValueChange = {
                harvestDate = it
            },
            label = {
                Text("Harvest Date")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
            },
            label = {
                Text("Location")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = quantity,
            onValueChange = {
                quantity = it
            },
            label = {
                Text("Quantity (KG)")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            OutlinedTextField(
                value = selectedFloralSource,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text("Floral Source")
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {

                floralSources.forEach { source ->

                    DropdownMenuItem(
                        text = {
                            Text(source)
                        },
                        onClick = {

                            selectedFloralSource = source
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                scope.launch {

                    val batchId =
                        "Batch-" + (1000..9999).random()

                    generatedBatchId = batchId

                    val harvest = Harvest(
                        date = harvestDate,
                        location = location,
                        quantity = quantity.toIntOrNull() ?: 0,
                        floralSource = selectedFloralSource,
                        batchId = batchId
                    )

                    harvestDao.insertHarvest(harvest)

                    resultText =
                        "Harvest Saved Successfully"

                    harvestDate = ""
                    location = ""
                    quantity = ""
                    selectedFloralSource = ""
                }
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {

            Text(
                text = "Save Harvest",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Generated Batch ID: $generatedBatchId",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = resultText,
            fontSize = 20.sp,
            color = Color.Green
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("dashboard")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Back to Dashboard")
        }
    }
}