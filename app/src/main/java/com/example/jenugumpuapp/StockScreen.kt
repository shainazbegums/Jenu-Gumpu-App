package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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

@Composable
fun StockScreen(navController: NavController) {

    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "jenu_database"
    ).build()

    val harvestDao = db.harvestDao()

    var totalStock by remember {
        mutableStateOf(0)
    }

    var harvestList by remember {
        mutableStateOf<List<Harvest>>(emptyList())
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        scope.launch {

            totalStock = harvestDao.getTotalStock() ?: 0

            harvestList = harvestDao.getAllHarvests()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp)
    ) {

        Text(
            text = "📦 Collective Stock",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFD54F)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Total Honey Stock",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$totalStock KG",
                    fontSize = 36.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Harvest History",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {

            items(harvestList) { harvest ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),

                    shape = RoundedCornerShape(16.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF3CD)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "📅 Date: ${harvest.date}"
                        )

                        Text(
                            text = "📍 Location: ${harvest.location}"
                        )

                        Text(
                            text = "⚖ Quantity: ${harvest.quantity} KG"
                        )

                        Text(
                            text = "🌼 Floral Source: ${harvest.floralSource}"
                        )

                        Text(
                            text = "🆔 Batch ID: ${harvest.batchId}"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("dashboard")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Back to Dashboard")
        }
    }
}