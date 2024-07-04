package com.example.ebasapps.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.R
import com.example.ebasapps.ui.theme.customFontFamily

@Composable
fun FavoriteScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF259c85)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Favorite",
                fontSize =36.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 8.dp),
                fontFamily = customFontFamily)
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(54.dp)
                    .align(Alignment.CenterVertically)
            )
            {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(shape = CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        Image(
            painter = painterResource(R.drawable.mainten),
            contentDescription = "Maintenance",
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Masih dalam pengembangan",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontFamily = customFontFamily,
            modifier = Modifier.padding(8.dp),
            lineHeight = 40.sp)
    }
}
