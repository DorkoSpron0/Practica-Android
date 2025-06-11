package com.example.clientenotas.ui.cliente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.ClienteViewmodel

@Composable
fun ClientListScreen(viewModel: ClienteViewmodel, navController: NavController) {
    val clientes by viewModel.clientes.collectAsState()
    val cliente by viewModel.cliente.collectAsState()

    var inputId by rememberSaveable { mutableStateOf("") }
    var clienteId by rememberSaveable { mutableStateOf("") } // usado solo al buscar

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 60.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(1f)  // ✅ Esto evita que el TextField empuje al icono fuera
                .padding(horizontal = 10.dp),
            label = { Text("Input Id") },
            value = inputId,
            onValueChange = {
                inputId = it
                clienteId = it

                val id = inputId.toIntOrNull()
                if (id != null) {
                    clienteId = id.toString()
                    viewModel.VMgetClienteById(id)
                }
            }
        )


        if(clienteId.isEmpty() || clienteId.isBlank()){
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
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                navController.navigate("cliente/${clientes[index].id}")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }else{
            cliente?.let { cliente ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            enabled = true,
                            onClick = {
                                navController.navigate("clienteDetails/${cliente.id}")
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
                            Text(cliente.id.toString(), fontSize = 12.sp)
                        }
                        Text(cliente.title, fontSize = 18.sp)
                    }

                    Text(
                        text = cliente.correo,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )

                    IconButton(
                        onClick = {
                            viewModel.VMdeleteCliente(cliente)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(
                        onClick = {
                            navController.navigate("cliente/${cliente.id}")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
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
            onClick = { navController.navigate("notasList") }
        ) {
            Text("Ver notas")
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
