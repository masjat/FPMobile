package com.example.ebasapps.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ebasapps.R

@Composable
fun ReadBook(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.size(60.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.mainten),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
        )
    }
}
