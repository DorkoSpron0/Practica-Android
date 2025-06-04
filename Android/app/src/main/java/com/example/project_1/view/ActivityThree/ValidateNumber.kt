@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.NumberViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValidateNumber(numberViewModel: NumberViewModel = viewModel()){
    /*
    * Objetivo: Aceptar solo números y validar longitud.
        - Campo de texto.
        - Botón de 'Validar'.
        - Cambiar borde a verde si está bien (10 dígitos), rojo si no.
        - Usar TextFieldColors dinámicos.
    * */

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = numberViewModel.number,
            onValueChange = {input ->
                input.filter { c: Char -> c.isDigit() }
                numberViewModel.number = input
                numberViewModel.numberIsValid = input.length == 10
            },
            label = { Text("Ingrese su número") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            isError = !numberViewModel.numberIsValid,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                 focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Green,
                focusedLabelColor = Color.Green,
                unfocusedLabelColor = Color.Green
            )
        )
    }
}