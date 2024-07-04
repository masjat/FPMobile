package com.example.ebasapps.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.book.BookDescription
import com.example.ebasapps.book.BookRepository
import com.example.ebasapps.ui.theme.customFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailBookPage(navController: NavController, bookId: String) {
    val intBookId = bookId.toIntOrNull() ?: 0
    val bookRepository = BookRepository(LocalContext.current)
    val book = remember { bookRepository.findBookById(intBookId) }

    Column(modifier = Modifier
        .padding(0.dp).background(Color(0xFF259c85))) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back Icon",
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.navigate("dashboard") }
                    .align(Alignment.CenterVertically)
                    .padding(12.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Detail Buku",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
                fontSize = 32.sp,
                textAlign = TextAlign.Start,
                fontFamily = customFontFamily,
                color = Color.White
            )
        }

        if (book != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 4.dp)
                    .background(Color.White)
            ) {
                BookDescription(navController = navController, book = book)
            }
        } else {
            Text(
                text = "Buku tidak ditemukan",
                modifier = Modifier.fillMaxSize().padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
