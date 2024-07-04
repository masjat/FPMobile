package com.example.ebasapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.ebasapps.dashboard.BottomNavigationBar
import com.example.ebasapps.dashboard.DashboardScreen
import com.example.ebasapps.page.ProfileScreen
import com.example.ebasapps.ui.theme.EBASAppsTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.ebasapps.book.BookRepository
import com.example.ebasapps.page.DetailBookPage
import com.example.ebasapps.page.FavoriteScreen
import com.example.ebasapps.page.ReadBook
import com.example.ebasapps.page.SignInPage
import com.example.ebasapps.page.SignUpPage


class MainActivity : ComponentActivity() {
    private lateinit var bookRepository: BookRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookRepository = BookRepository(context = this)

        setContent {
            EBASAppsTheme {
                App(bookRepository = bookRepository)
            }
        }
    }
}
@Composable
fun App(bookRepository: BookRepository) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "detail_book/{bookId}" && currentRoute != "register" && currentRoute != "login" && currentRoute != "read_book") {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dashboard") {
                DashboardScreen(navController = navController, bookRepository = bookRepository)
            }
            composable("profile") {
                ProfileScreen(navController = navController)
            }
            composable("favorite") {
                FavoriteScreen(navController = navController)
            }
            composable("login") {
                SignInPage(navController = navController)
            }
            composable("register") {
                SignUpPage(navController = navController)
            }
            composable(
                "detail_book/{bookId}",
                arguments = listOf(navArgument("bookId") { type = NavType.StringType })
            ) { backStackEntry ->
                val bookId = backStackEntry.arguments?.getString("bookId") ?: "0"
                DetailBookPage(navController = navController, bookId = bookId)
            }
            composable("read_book"){
                ReadBook(navController = navController)
            }
        }
    }
}







