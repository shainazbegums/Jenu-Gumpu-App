package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfitScreen(navController: NavController) {

    var retailPrice by remember {
        mutableStateOf("")
    }

    var wholesalePrice by remember {
        mutableStateOf("")
    }

    var filteringCost by remember {
        mutableStateOf("")
    }

    var finalProfit by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp)
    ) {

        Text(
            text = "Profit Calculator",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = retailPrice,
            onValueChange = {
                retailPrice = it
            },
            label = {
                Text("Retail Price")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = wholesalePrice,
            onValueChange = {
                wholesalePrice = it
            },
            label = {
                Text("Wholesale Price")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = filteringCost,
            onValueChange = {
                filteringCost = it
            },
            label = {
                Text("Filtering Cost")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                val retail =
                    retailPrice.toIntOrNull() ?: 0

                val wholesale =
                    wholesalePrice.toIntOrNull() ?: 0

                val filter =
                    filteringCost.toIntOrNull() ?: 0

                val profit =
                    retail - wholesale - filter

                finalProfit = "₹ $profit"
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {

            Text(
                text = "Calculate Profit",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Final Profit: $finalProfit",
            fontSize = 24.sp
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