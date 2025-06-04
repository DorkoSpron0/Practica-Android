package com.example.project_1.view.transitions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TemaDinamico(){

    var isDark by rememberSaveable { mutableStateOf(false) }
    var colorScheme = if(isDark) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme
    ){
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ){
            Text("hola mundo")
            Button(
                onClick = {isDark = !isDark}
            ) { Text("Cambiar tema") }
        }
    }
}