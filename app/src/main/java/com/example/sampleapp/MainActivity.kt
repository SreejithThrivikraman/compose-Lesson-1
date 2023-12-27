package com.example.sampleapp

import android.os.Bundle
import android.util.Log
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
import org.w3c.dom.NameList


val nameList = mutableStateListOf("Jacob", "Raswan", "Zaheer")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val greetingState by remember { mutableStateOf(nameList) }
    val newNameState = remember { mutableStateOf("")}
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Greeting(greetingState,
                 newNameState.value,
                 { greetingState.add(newNameState.value)
                   newNameState.value = ""
                 },
                 { newName -> newNameState.value = newName })
    }
}


@Composable
fun Greeting(greetingState : List<String>,
             newName :String,
             buttonClick : () -> Unit,
             textFieldUpdate : (newName: String) -> Unit) {

        greetingState.forEach { item ->
            Text(text = item)
        }

        TextField(value = newName, onValueChange = textFieldUpdate , label = { Text("Enter new Name")})

        Button(onClick =  buttonClick) {
            Text("Add new Name")
        }
}


@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    MainScreen()
}