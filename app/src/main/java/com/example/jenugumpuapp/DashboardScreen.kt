package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun DashboardScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "🍯 Jenu-Gumpu Dashboard\nಜೇನು-ಗುಂಪು ಡ್ಯಾಶ್‌ಬೋರ್ಡ್",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6D4C41)
        )

        Spacer(modifier = Modifier.height(30.dp))

        DashboardCard(
            title = "🍯 Harvest Log / ಕೊಯ್ಲು ದಾಖಲೆ"
        ) {
            navController.navigate("harvest")
        }

        DashboardCard(
            title = "💰 Profit Calculator / ಲಾಭ ಲೆಕ್ಕ"
        ) {
            navController.navigate("profit")
        }

        DashboardCard(
            title = "🍯 Honey Analysis / ಜೇನು ವಿಶ್ಲೇಷಣೆ"
        ) {
            navController.navigate("analysis")
        }

        DashboardCard(
            title = "📦 Collective Stock / ಒಟ್ಟು ಸಂಗ್ರಹ"
        ) {
            navController.navigate("stock")
        }

        DashboardCard(
            title = "📸 AI Honey Scanner"
        ) {
            navController.navigate("imageAnalysis")
        }

        DashboardCard(
            title = "💰 Price Monitor"
        ){
            navController.navigate("priceMonitor")
        }


        DashboardCard(
            title = " Harvest Guidelines"
        ){
            navController.navigate("guidelines")
       }

        DashboardCard(
            title = " Analytics Charts"
        ){
            navController.navigate("charts")
        }


        Spacer(modifier = Modifier.height(20.dp))




    }
}

@Composable
fun DashboardCard(
    title: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(vertical = 10.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFE082)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )
        }
    }
}