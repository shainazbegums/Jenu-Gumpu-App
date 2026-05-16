package com.example.jenugumpuapp

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.TakePicturePreview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ImageAnalysisScreen(navController: NavController) {

    var predictionResult by remember {
        mutableStateOf("")
    }

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var capturedImage by remember {
        mutableStateOf<Bitmap?>(null)
    }

    val scope = rememberCoroutineScope()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            selectedImageUri = uri

            val predictions = listOf(
                "🐝 Grade A Organic Honey",
                "🍯 Wild Forest Honey",
                "🌼 Floral Honey Detected",
                "⭐ Premium Natural Honey",
                "⚠ Low Purity Honey Sample"
            )

            scope.launch {

                predictionResult = "⏳ Analyzing Honey..."

                delay(2000)

                predictionResult = predictions.random()
            }
        }

    val cameraLauncher =
        rememberLauncherForActivityResult(
            contract = TakePicturePreview()
        ) { bitmap ->

            capturedImage = bitmap

            val predictions = listOf(
                "🐝 Grade A Organic Honey",
                "🍯 Wild Forest Honey",
                "🌼 Floral Honey Detected",
                "⭐ Premium Natural Honey",
                "⚠ Low Purity Honey Sample"
            )

            scope.launch {

                predictionResult = "⏳ Analyzing Honey..."

                delay(2000)

                predictionResult = predictions.random()
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.honey_logo),
            contentDescription = "Honey Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "📸 AI Honey Scanner",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFECB3)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "🖼 Upload Honey Image",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        imagePickerLauncher.launch("image/*")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Choose Image")
                }

                Spacer(modifier = Modifier.height(12.dp))


            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        selectedImageUri?.let {

            AsyncImage(
                model = it,
                contentDescription = "Selected Honey Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
        }

        capturedImage?.let {

            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Captured Honey Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (predictionResult.isNotEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF3CD)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Prediction Result",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5D4037)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = predictionResult,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
            }
        }

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