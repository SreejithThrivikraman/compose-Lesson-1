package com.example.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


val nameList = mutableStateListOf("Jacob", "Raswan", "Zaheer")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()

        }
    }
}

@Composable
fun Greeting() {
    val greetingState by remember { mutableStateOf(nameList) }
    var newName by remember { mutableStateOf("")}
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        greetingState.forEach { item ->
            Text(text = item)
        }

        TextField(value = newName, onValueChange = {newName = it}, label = { Text("Enter new Name")})

        Button(onClick = {
            greetingState.add(newName)
            newName = ""
        }) {
            Text("Add new Name")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    Greeting()
}