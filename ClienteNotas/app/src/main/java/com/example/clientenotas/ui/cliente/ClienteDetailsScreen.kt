package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel

@Composable
fun ClienteDetailsScreen(clienteViewmodel: ClienteViewmodel, navController: NavController, clienteId: String?){

    val id = clienteId?.toIntOrNull()

    LaunchedEffect(id) {
        id?.let {
            clienteViewmodel.VMgetClienteConNotas(it)
        }
    }

    val cliente = clienteViewmodel.clienteConNotas.collectAsState().value

    cliente?.let {
        Column {
            Text("Cliente: ${it.cliente.correo}")
            Text("Notas:")
            it.notas.forEach { nota ->
                Text("- ${nota.contenido}")
            }
        }
    } ?: Text("Cargando...")
}