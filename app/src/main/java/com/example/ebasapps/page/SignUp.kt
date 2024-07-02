package com.example.ebasapps.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebasapps.R

@Composable
fun SignUpPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(true) }
    var isConfirmPasswordEntered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.ebas_logo), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(40.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Alamat Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Kata Sandi") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        val passwordMatchIcon = if (isConfirmPasswordEntered && isPasswordValid) R.drawable.cek else 0
        val passwordMatchDescription = if (isPasswordValid) "Kata sandi cocok" else "Kata sandi tidak cocok"
        val iconTint = if (isPasswordValid) Color.Green else Color.Gray

        TextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                isPasswordValid = it == password // Validating against password
                isConfirmPasswordEntered = it.isNotEmpty() // Set flag when confirmation password is entered
            },
            label = { Text("Masukkan Ulang Kata Sandi") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (passwordMatchIcon != 0) {
                    Icon(
                        painter = painterResource(id = passwordMatchIcon),
                        contentDescription = passwordMatchDescription,
                        modifier = Modifier.size(32.dp),
                        tint = iconTint
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Handle registration */ },
            colors = ButtonDefaults.buttonColors(Color(0xFF259C85)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Daftar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.popBackStack() }) {
            Text(text = "Sudah punya akun? Masuk", fontSize = 12.sp)
        }
    }
}
