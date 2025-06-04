package com.example.project_1.viewmodel.ActivityThree

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.w3c.dom.Text

// Launc Effect

@SuppressLint("UnrememberedMutableState")
@Composable
fun CargaSimulada() {

/*
*
* Objetivo: Simular proceso con estado de carga.
- Al hacer clic, cambia a 'Cargando...' durante 2 segundos.
- Deshabilita el botón.
- Luego cambia a 'Listo '.
- Todo controlado con estado en el ViewModel.
*
* */

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var click by mutableStateOf(false)
        var texto by mutableStateOf("Púlsame")

        LaunchedEffect(click) {
            if (click) {
                texto = "Cargando..."
                delay(2000L)
                texto = "Cargado"
            }
        }

        Button(onClick = { click = !click }) {
            Text(texto)
        }

    }
}