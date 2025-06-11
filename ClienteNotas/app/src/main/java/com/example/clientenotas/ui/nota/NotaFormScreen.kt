package com.example.clientenotas.ui.nota

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel
import com.example.clientenotas.viewmodel.NotaViewModel

@Composable
fun NotaFormScreen(notaViewModel: NotaViewModel, navController: NavController) {
    var contenido by rememberSaveable { mutableStateOf("") }
    var fecha by rememberSaveable { mutableStateOf("") }
    var clienteId by rememberSaveable { mutableIntStateOf(0) }

    var expanded by rememberSaveable { mutableStateOf(false) }

    // contenido, fecha, clienteId

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                    label = { Text("Contenido") },
                    value = contenido,
                    onValueChange = {input -> contenido = input}
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                    label = { Text("Fecha") },
                    value = fecha,
                    onValueChange = {input -> fecha = input}
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                    label = { Text("clienteId") },
                    value = clienteId.toString(),
                    onValueChange = {input -> clienteId = input.toIntOrNull() ?: 1}
                )

                Button(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
                    onClick = {
                        notaViewModel.VMinsert(contenido, fecha, clienteId)
                        navController.navigate("notasList")
                    }
                ) { Text("Agregar Nota") }

                Button(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),

                    onClick = {
                        navController.navigate("notasList")
                    }
                ) { Text("Ver Nota") }
            }
        }
    }
}