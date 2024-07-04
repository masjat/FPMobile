package com.example.ebasapps.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.R

@Composable
fun ProfileScreen(navController: NavController) {
    var isLoggedIn by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf("AditPamungkas@gmail.com") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoggedIn) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(128.dp)
                    .background(Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = email,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    isLoggedIn = false
                    email = ""
                    navController.navigate("login") {
                        popUpTo("profile") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 128.dp)
            ) {
                Text(text = "Keluar")
            }
        } else {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(Color.Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Placeholder Image",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Handle login
                    isLoggedIn = true
                    email = "AditPamungkas@gmail.com"
                    navController.navigate("profile") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 128.dp)
            ) {
                Text(text = "Masuk")
            }
        }
    }
}
