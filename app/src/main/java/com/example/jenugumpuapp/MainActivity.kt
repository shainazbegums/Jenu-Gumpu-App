package com.example.jenugumpuapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MaterialTheme(

                colorScheme =
                    if (ThemeState.isDarkMode.value)
                        darkColorScheme(
                            background = Color.Black,
                            surface = Color.DarkGray
                        )
                    else
                        lightColorScheme()

            ) {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {

                    composable("login") {
                        LoginScreen(navController)
                    }

                    composable("dashboard") {
                        DashboardScreen(navController)
                    }

                    composable("imageAnalysis") {
                        ImageAnalysisScreen(navController)
                    }

                    composable("harvest") {
                        HarvestScreen(navController)
                    }

                    composable("profit") {
                        ProfitScreen(navController)
                    }

                    composable("analysis") {
                        AnalysisScreen(navController)
                    }

                    composable("stock") {
                        StockScreen(navController)
                    }

                    composable("priceMonitor") {
                        PriceMonitorScreen(navController)
                    }

                    composable("guidelines") {
                        GuidelinesScreen(navController)
                    }

                    composable("charts") {
                        ChartScreen(navController)
                    }
                }
            }
        }
    }
}