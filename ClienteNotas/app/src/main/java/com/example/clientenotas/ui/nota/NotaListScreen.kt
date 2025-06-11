package com.example.clientenotas.ui.nota

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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.NotaViewModel

@Composable
fun NotaListScreen(viewModel: NotaViewModel, navController: NavController) {
    val notas by viewModel.notas.collectAsState()
    val notasCliente by viewModel.clienteConNotas.collectAsState()

    var inputId by rememberSaveable { mutableStateOf("") }
    var clienteId by rememberSaveable { mutableStateOf("") }

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
                    viewModel.VMgetNotasDeCliente(id)

                    print("NOOOOOOTAAAASS" + notasCliente)
                }
            }
        )

        if(clienteId.isEmpty() || clienteId.isBlank()){
            LazyColumn(
                modifier = Modifier.weight(1f), // Ocupa el espacio restante
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(notas.size) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier.padding(20.dp)
                            ){
                                Text(
                                    text = notas[index].id.toString(),
                                )
                            }

                            Text(
                                text = notas[index].contenido,
                            )
                        }

                        Text(text = notas[index].fecha)
                        Text(text = notas[index].clienteId.toString())

                        IconButton(
                            onClick = {
                                viewModel.VMdelete(notas[index])
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }else{
            notasCliente?.let {
                LazyColumn(
                    modifier = Modifier.weight(1f), // Ocupa el espacio restante
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(notas.size) { index ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier.padding(20.dp)
                                ){
                                    Text(
                                        text = notasCliente!!.notas[index].id.toString(),
                                    )
                                }

                                Text(
                                    text = notasCliente!!.notas[index].contenido,
                                )
                            }

                            Text(text = notasCliente!!.notas[index].fecha)
                            Text(text = notasCliente!!.notas[index].clienteId.toString())

                            IconButton(
                                onClick = {
                                    viewModel.VMdelete(notas[index])
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { navController.navigate("notasForm") }
        ) {
            Text("Agregar nota")
        }


        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { navController.navigate("clientList") }
        ) {
            Text("Ver clientes")
        }
    }
}
