package com.example.ebasapps.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.ui.theme.customFontFamily

@Composable
fun BookDescription(navController: NavController, book: Book) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)) {
        Text(
            text = book.title,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp,
            fontFamily = customFontFamily,
            modifier = Modifier.fillMaxWidth())
        Text(
            text = "Penulis: ${book.author}",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontFamily = customFontFamily,
            modifier = Modifier.fillMaxWidth())
        Text(
            text = "Rating: ${book.rating}",
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontFamily = customFontFamily,
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = book.imageResId),
            contentDescription = "Book Cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Deskripsi:",
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontFamily = customFontFamily,
            modifier = Modifier.fillMaxWidth())
        Text(text = book.description,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify,
            fontFamily = customFontFamily,)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("read_book")},
            modifier = Modifier.fillMaxWidth().size(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF259c85),
                contentColor = Color.White
            )) {
            Text(text = "Baca Buku",
                fontSize = 24.sp,)
        }
    }
}