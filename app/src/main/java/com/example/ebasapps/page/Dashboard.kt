package com.example.ebasapps.dashboard

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ebasapps.R
import com.example.ebasapps.book.Book
import com.example.ebasapps.book.BookRepository


@Composable
fun DashboardScreen(navController: NavController,bookRepository:BookRepository) {
    val books by remember { mutableStateOf(bookRepository.getBooks()) }

    Column {
        DashboardHeader()

        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            modifier = Modifier.padding(0.dp)
        ) {
            items(books) { book ->
                BookItem(book = book) {
                    navController.navigate("detail_book/${book.id}")
                }
            }
        }
    }

}

@Composable
fun DashboardHeader() {
    val context = LocalContext.current
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .background(Color(0xFF259c85)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.ebaslogo),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .size(64.dp)
                    .padding(2.dp)
                    .align(Alignment.CenterVertically)
            )
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(text = stringResource(R.string.find_book),fontSize = 16.sp) },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
                    .padding(horizontal = 4.dp, vertical = 4.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(12.dp)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        Toast.makeText(context, "Search: $searchText", Toast.LENGTH_SHORT).show()
                    }
                ),
                singleLine = true
            )
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(54.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = stringResource(R.string.name_profile),
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}
@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(vertical = 18.dp)) {
            Image(
                painter = painterResource(book.imageResId),
                contentDescription = book.title,
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = book.title, style = MaterialTheme.typography.titleLarge)
                Text(text = book.author, style = MaterialTheme.typography.titleMedium)
                Text(text = "Rating: ${book.rating}", style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "dashboard"

    NavigationBar(
        containerColor = Color(0xFF259c85)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Dashboard", modifier = Modifier.size(32.dp)) },
            label = { Text("Dashboard", fontSize = 16.sp) },
            selected = currentRoute == "dashboard",
            onClick = {
                navController.navigate("dashboard") {
                    popUpTo("dashboard") { inclusive = true }
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite", modifier = Modifier.size(32.dp)) },
            label = { Text("Favorite", fontSize = 16.sp) },
            selected = currentRoute == "favorite",
            onClick = {
                navController.navigate("favorite") {
                    popUpTo("favorite") { inclusive = true }
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile", modifier = Modifier.size(32.dp)) },
            label = { Text("Profile", fontSize = 16.sp) },
            selected = currentRoute == "profile",
            onClick = {
                navController.navigate("profile") {
                    popUpTo("profile") { inclusive = true }
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
    }
}





