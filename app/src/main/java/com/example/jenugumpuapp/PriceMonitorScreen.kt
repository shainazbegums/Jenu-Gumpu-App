package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PriceMonitorScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "💰 Honey Price Monitor",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(30.dp))

        PriceCard(
            title = "🏪 Retail Market Price",
            price = "₹ 700 / KG"
        )

        PriceCard(
            title = "📦 Wholesale Market Price",
            price = "₹ 450 / KG"
        )

        PriceCard(
            title = "📈 Estimated Collective Profit",
            price = "₹ 12,500"
        )

        Spacer(modifier = Modifier.height(30.dp))

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
fun PriceCard(
    title: String,
    price: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFD54F)
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = price,
                fontSize = 28.sp,
                color = Color(0xFF4E342E)
            )
        }
    }
}