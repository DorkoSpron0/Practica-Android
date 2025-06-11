package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel

@Composable
fun ClientListScreen(viewModel: ClienteViewmodel, navController: NavController) {
    val clientes by viewModel.clientes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 60.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f), // Ocupa el espacio restante
        ) {
            items(clientes.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            enabled = true,
                            onClick = {
                                navController.navigate("clienteDetails/${clientes[index].id}")
                            }
                        )
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.padding(10.dp)
                        ){
                            Text(clientes[index].id.toString(), fontSize = 12.sp)
                        }
                        Text(clientes[index].title, fontSize = 18.sp)
                    }

                    Text(
                        text = clientes[index].correo,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )

                    IconButton(
                        onClick = {
                            viewModel.VMdeleteCliente(clientes[index])
                        }
                    ) { Text("Remove") }
                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { navController.navigate("clienteForm") }
        ) {
            Text("Agregar cliente")
        }


        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { navController.navigate("notasForm") }
        ) {
            Text("Agregar nota")
        }
    }
}
