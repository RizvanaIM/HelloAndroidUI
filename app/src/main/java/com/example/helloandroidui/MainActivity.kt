package com.example.helloandroidui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloandroidui.ui.theme.HelloAndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloAndroidUITheme {
                AppUI()
            }
        }
    }
}

@Composable
fun AppUI() {
    val context = LocalContext.current  // needed for Toast

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {


        // 3️⃣ Image
        Image(
            painter = painterResource(id = R.drawable.android_logo_foreground),
            contentDescription = "Android Logo",
            modifier = Modifier.size(100.dp)
        )

        // 1️⃣ Text (Welcome message)
        Text(text = "Welcome to Android Development!")

        Spacer(modifier = Modifier.height(24.dp))

        // 4️⃣ TextField (user input)
        val name = remember { mutableStateOf("") }
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Personalized Toast button
        Button(onClick = {
            Toast.makeText(context, "Hello ${name.value}!", Toast.LENGTH_SHORT).show()
        }) {
            Text("Say Hello")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAppUI() {
    HelloAndroidUITheme {
        AppUI()
    }
}
