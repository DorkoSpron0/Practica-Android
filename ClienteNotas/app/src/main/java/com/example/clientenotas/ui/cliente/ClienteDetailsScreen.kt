package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel
import kotlin.text.toIntOrNull

@Composable
fun ClienteDetailsScreen(clienteViewmodel: ClienteViewmodel, navController: NavController, clienteId: String?){

    val id = clienteId?.toIntOrNull()

    LaunchedEffect(id) {
        id?.let {
            clienteViewmodel.VMgetClienteById(it)
        }
    }

    val cliente = clienteViewmodel.cliente.collectAsState().value


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(cliente?.id.toString())
        Text(cliente?.title ?: "No existe")
        Text(cliente?.correo ?: "No existe")

        Button(
            onClick = {navController.navigate("clientList")}
        ) { Text("Ver clientes") }
    }

}