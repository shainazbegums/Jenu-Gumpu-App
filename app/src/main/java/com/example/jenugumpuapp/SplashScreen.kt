package com.example.jenugumpuapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {

        delay(2500)

        navController.navigate("login")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC107)),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "🍯",
                fontSize = 80.sp
            )

            Image(
                painter = painterResource(id = R.drawable.honey_logo),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
            )

            Text(
                text = "Jenu-Gumpu",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E342E)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Honey Producer's Collective",
                fontSize = 20.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "ಜೇನು-ಗುಂಪು",
                fontSize = 24.sp,
                color = Color(0xFF4E342E)
            )
        }
    }
}