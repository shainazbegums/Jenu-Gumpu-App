package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.jenugumpuapp.database.AppDatabase
import kotlinx.coroutines.launch

@Composable
fun AnalyticsScreen(navController: NavController) {

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

    var totalHarvests by remember {
        mutableStateOf(0)
    }

    var totalBatches by remember {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        scope.launch {

            totalStock =
                harvestDao.getTotalStock() ?: 0

            totalHarvests =
                harvestDao.getHarvestCount()

            totalBatches =
                harvestDao.getBatchCount()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "📊 Analytics Dashboard",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(25.dp))

        AnalyticsCard(
            title = "🍯 Total Honey Collected",
            value = "$totalStock KG"
        )

        AnalyticsCard(
            title = "📦 Total Batches",
            value = "$totalBatches"
        )

        AnalyticsCard(
            title = "🧾 Total Harvest Entries",
            value = "$totalHarvests"
        )

        AnalyticsCard(
            title = "💰 Estimated Profit",
            value = "₹ ${totalStock * 350}"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("dashboard")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("⬅ Back to Dashboard")
        }
    }
}

@Composable
fun AnalyticsCard(
    title: String,
    value: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFD54F)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = value,
                fontSize = 28.sp,
                color = Color(0xFF4E342E)
            )
        }
    }
}