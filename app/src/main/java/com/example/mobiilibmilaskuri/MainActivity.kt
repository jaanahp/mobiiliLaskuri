package com.example.mobiilibmilaskuri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobiilibmilaskuri.ui.theme.MobiiliBMIlaskuriTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiiliBMIlaskuriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var height by remember { mutableStateOf("")}
    var weight by remember { mutableStateOf("")}
    var bmi = if (height != "" && weight != "") (1.3 * weight.toDouble()) / ((height.toDouble() / 100).pow(2.5)) else "Arvo ei voi olla nolla"
    Column{
        TextField(value = "", onValueChange = {height = it},
            label = { Text("Pituus (cm)")})
        TextField(value = "", onValueChange = {weight = it},
            label = { Text("Paino (kg)")})
        Button(onClick = {
            height = "176"
            weight = "86.8"
        }) {
            Text(text = "Laske")
        }
        Text(text = bmi.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiiliBMIlaskuriTheme {
        Greeting("Android")
    }
}