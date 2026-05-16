package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AnalysisScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🍯 Honey Analytics",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6D4C41)
        )

        Spacer(modifier = Modifier.height(25.dp))

        SummaryCard("🍯 Honey Collected", "250 KG")

        SummaryCard("💰 Estimated Profit", "₹ 45,000")

        SummaryCard("📦 Total Batches", "18")

        SummaryCard("🌼 Top Floral Source", "Wildflower")

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                navController.navigate("dashboard")
            }
        ) {
            Text("Back to Dashboard")
        }
    }
}

@Composable
fun SummaryCard(
    title: String,
    value: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFE082)
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
                fontSize = 26.sp,
                color = Color(0xFF4E342E)
            )
        }
    }
}