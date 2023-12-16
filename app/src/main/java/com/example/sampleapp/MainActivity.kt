package com.example.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


val nameList = mutableListOf("Jacob", "Raswan", "Zaheer")

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
    val greetingState = remember { mutableStateListOf("Jacob", "Raswan", "Zaheer")}
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        for (item in greetingState) {
            Text(
                text = "$item",
            )
        }

        Button(
            onClick = { greetingState.add("1")
                         greetingState = greetingState.toMutableList() }
        ) {
            Text("Add new Name")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    Greeting()
}