package com.example.mobiilibmilaskuri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var bmi by remember { mutableStateOf("")}
    var buttonEnabled by remember { mutableStateOf(false)}

    fun calculateBmi() {
        val heightDouble = height.toDouble()
        val weightDouble = weight.toDouble()
        bmi = if (height != "" && weight != "") {
            ((1.3 * weightDouble) / ((heightDouble / 100).pow(2.5))).toString()
        } else "Arvo ei voi olla tyhjä"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = height,
            onValueChange = {height = it},
            modifier = Modifier.padding(top = 8.dp),
            textStyle = TextStyle.Default.copy(fontSize = 28.sp),
            label = { Text("Pituus (cm)")})
        TextField(
            value = weight,
            onValueChange = {weight = it},
            modifier = Modifier.padding(top = 8.dp),
            textStyle = TextStyle.Default.copy(fontSize = 28.sp),
            label = { Text("Paino (kg)")})
        Text(
            text = bmi,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 26.sp
        )
        Row {
        Checkbox(
            checked = buttonEnabled,
            onCheckedChange = {buttonEnabled = it},
            modifier = Modifier.padding(top = 8.dp),
            )
            Text(
                text = "Olen aikuinen",
                modifier = Modifier.padding(9.dp))
        }

        Button(
            onClick = { calculateBmi() },
            modifier = Modifier.padding(top = 8.dp),
            enabled = buttonEnabled
        ) {
            Text(text = "Laske")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobiiliBMIlaskuriTheme {
        Greeting("Android")
    }
}