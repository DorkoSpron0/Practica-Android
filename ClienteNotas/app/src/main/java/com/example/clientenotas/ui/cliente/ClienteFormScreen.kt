package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel

@Composable
fun ClienteFormScreen(viewModel: ClienteViewmodel, navController: NavController){

    var title by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }

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
                        label = { Text("Title") },
                        value = title,
                        onValueChange = {input -> title = input}
                    )

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                        label = { Text("Correo") },
                        value = correo,
                        onValueChange = {input -> correo = input}
                    )

                    Button(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
                        onClick = {
                            viewModel.VMagregarCliente(title, correo)
                            navController.navigate("clientList")
                        }
                    ) { Text("Agregar cliente") }
                }
            }
        }
    }
