package com.example.clientenotas.ui.nota

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clientenotas.viewmodel.NotaViewModel

@Composable
fun NotaListScreen(viewModel: NotaViewModel, navController: NavController) {
    val notas by viewModel.notas.collectAsState()

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
            items(notas.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
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
            onClick = { navController.navigate("notasList") }
        ) {
            Text("Ver notas")
        }
    }
}
