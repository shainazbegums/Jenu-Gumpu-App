package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun GuidelinesScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "🌿 Sustainable Harvest Guidelines",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(25.dp))

        GuidelineCard(
            title = "🐝 Protect Bee Colonies",
            description =
                "Do not destroy the bee colony while harvesting honey."
        )

        GuidelineCard(
            title = "🔥 Use Smoke Carefully",
            description =
                "Use mild smoke to calm bees without harming them."
        )

        GuidelineCard(
            title = "🍯 Harvest Mature Honeycombs",
            description =
                "Collect only mature honeycombs to ensure honey quality."
        )

        GuidelineCard(
            title = "🌳 Preserve Forest Ecosystem",
            description =
                "Avoid cutting trees or damaging forest habitats."
        )

        GuidelineCard(
            title = "💧 Maintain Clean Storage",
            description =
                "Store honey in clean and food-safe containers."
        )

        Spacer(modifier = Modifier.height(25.dp))

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
fun GuidelineCard(
    title: String,
    description: String
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
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = description,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}