package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel

@Composable
fun ClienteNotasDetailsScreen(clienteViewmodel: ClienteViewmodel, navController: NavController, clienteId: String?){

    val id = clienteId?.toIntOrNull()

    LaunchedEffect(id) {
        id?.let {
            clienteViewmodel.VMgetClienteConNotas(it)
        }
    }

    val cliente = clienteViewmodel.clienteConNotas.collectAsState().value

    cliente?.let {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Cliente: ${it.cliente.correo}")
            Text("Notas:")
            it.notas.forEach { nota ->
                Text("- ${nota.contenido}")
            }


            Button(
                modifier = Modifier.padding(horizontal = 30.dp),

                onClick = {
                    navController.navigate("clientList")
                }
            ) { Text("Ver Clientes") }
        }
    } ?: Text("Cargando...")


}