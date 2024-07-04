package com.example.ebasapps.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.R


@Composable
fun SignInPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf("") }
    val correctEmail = "AditPamungkas@gmail.com"
    val correctPassword = "password123"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ebas_logo), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(100.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
                emailError = if (it.isEmpty()) "Email tidak boleh kosong" else ""
                loginError = ""
            },
            label = { Text("Alamat Email") },
            isError = emailError.isNotEmpty() || loginError.isNotEmpty(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError.isNotEmpty()) {
            Text(text = emailError, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = if (it.isEmpty()) "Password tidak boleh kosong" else ""
                loginError = ""
            },
            label = { Text("Kata Sandi") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        painter = painterResource(if (passwordVisibility) R.drawable.unhide else R.drawable.hide),
                        contentDescription = if (passwordVisibility) "Sembunyikan kata sandi" else "Tampilkan kata sandi"
                    )
                }
            },
            isError = passwordError.isNotEmpty() || loginError.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (passwordError.isNotEmpty()) {
            Text(text = passwordError, color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (loginError.isNotEmpty()) {
            Text(text = loginError, color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                when {
                    email.isEmpty() -> emailError = "Email tidak boleh kosong"
                    password.isEmpty() -> passwordError = "Password tidak boleh kosong"
                    email != correctEmail -> loginError = "Email tidak ditemukan"
                    password != correctPassword -> loginError = "Password salah"
                    else -> {
                        navController.navigate("dashboard") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF259C85)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Masuk",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text(text = "Belum punya akun? Daftar", fontSize = 16.sp)
        }
    }
}
