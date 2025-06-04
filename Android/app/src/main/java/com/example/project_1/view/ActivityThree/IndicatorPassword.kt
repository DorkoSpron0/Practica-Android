@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.IndicatorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndicatorPassword(indicatorViewModel: IndicatorViewModel = viewModel()){


    /*
    *
    * Objetivo: Cambiar el color del texto según la fortaleza.
    - Débil: < 6 (rojo), Media: < 10 (amarillo), Fuerte: >=10 (verde).
    - Mostrar una barra o texto que diga 'Débil / Media / Fuerte'.
    *
    * */

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = indicatorViewModel.password,
            onValueChange = {input ->
                indicatorViewModel.password = input
                indicatorViewModel.colorIndicator = when {
                    input.length >= 10 -> Color.Green
                    input.length in 6..9 -> Color.Yellow
                    else -> Color.Red
                }
            },
            label = { Text("Contraseña") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = indicatorViewModel.colorIndicator
            )
        )

       if(indicatorViewModel.colorIndicator.equals(Color.Red)){
           Text("Débil", color = Color.Red)
       }

        if(indicatorViewModel.colorIndicator.equals(Color.Yellow)){
            Text("Medio", color = Color.Yellow)
        }

        if(indicatorViewModel.colorIndicator.equals(Color.Yellow)){
            Text("Fuerte", color = Color.Green)
        }
    }
}